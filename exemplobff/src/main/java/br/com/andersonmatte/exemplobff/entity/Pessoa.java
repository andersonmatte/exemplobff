package br.com.andersonmatte.exemplobff.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pessoa {

    private long id;
    @JsonProperty("name")
    private String nome;

    private String email;
    @JsonProperty("username")
    private String usuario;

    public Pessoa(){

    }

    public Pessoa(long id, String nome, String email, String usuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
