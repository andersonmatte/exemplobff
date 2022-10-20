package br.com.andersonmatte.exemplobff.repository;

import br.com.andersonmatte.exemplobff.entity.Pessoa;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PessoaRepository {

    public List<Pessoa> getPessoas() {
        // API FAKE busca no sonplaceholder os usuários
        final String uri = "https://jsonplaceholder.typicode.com/users";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return this.getPessoasBFF(result);
    }

    private List<Pessoa> getPessoasBFF(String result) {
        // Lista que vai conter o retorno trabalhado para o BFF
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
            // Aqui é criada a lista de objeto Pessoa que vai ser parseado
            List<Pessoa> pessoasLista = Arrays.asList(mapper.readValue(result, Pessoa[].class));
            if (!pessoasLista.isEmpty()) {
                for (Pessoa p : pessoasLista) {
                    Pessoa pessoa = new Pessoa(p.getId(), p.getNome(), p.getEmail(), p.getUsuario());
                    pessoas.add(pessoa);
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

}