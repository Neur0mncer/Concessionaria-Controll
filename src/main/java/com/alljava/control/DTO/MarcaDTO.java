package com.alljava.control.DTO;

import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO {
    private long id;
    private String descricao;
    private List<Modelo> modelos;

    public MarcaDTO(Marca marca) {
        id = marca.getId();
        descricao = marca.getDescricao();
    }

    public Marca transformaParaObjeto(){
        return new Marca(id, descricao, modelos);
    }


}
