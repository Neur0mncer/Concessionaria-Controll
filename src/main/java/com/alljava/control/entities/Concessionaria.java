package com.alljava.control.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_concessionaria")
public class Concessionaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "name", nullable = false)
    private String nome;
    @Column (name = "cidade")
    private String cidade;
    @Column (name = "telefone")
    private String telefone;
    @Column (name = "email")
    private String email;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
