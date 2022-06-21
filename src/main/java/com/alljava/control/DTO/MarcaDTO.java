package com.alljava.control.DTO;

import com.alljava.control.entities.Marca;

public class MarcaDTO {
    private long id;
    private String descricao;

    public MarcaDTO() {
    }

    public MarcaDTO(Marca marca) {
        id = marca.getId();
        descricao = marca.getDescricao();
    }

    public MarcaDTO(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
