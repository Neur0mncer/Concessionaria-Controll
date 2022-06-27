package com.alljava.control.DTO;

import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModeloDTO {

    private long id;
    private String descricao;
    private Marca marca;

    public ModeloDTO(Modelo modelo) {
        id = modelo.getId();
        descricao = modelo.getDescricao();
        marca = modelo.getMarca();
    }
}
