package com.alljava.control.DTO;

import com.alljava.control.entities.Concessionaria;
import jdk.jfr.DataAmount;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Optional;

public class ConcessionariaDTO implements Serializable {

    private long id;
    private String nome;
    private String cidade;
    private String telefone;
    private String email;

    public ConcessionariaDTO() {
    }

    public ConcessionariaDTO(long id, String nome, String cidade, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
    }

    public ConcessionariaDTO(Concessionaria concessionaria) {
        id = concessionaria.getId();
        nome = concessionaria.getNome();
        cidade = concessionaria.getCidade();
        telefone = concessionaria.getTelefone();
        email = concessionaria.getEmail();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
