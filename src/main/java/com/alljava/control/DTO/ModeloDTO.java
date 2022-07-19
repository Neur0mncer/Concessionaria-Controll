package com.alljava.control.DTO;

import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModeloDTO {

    private long id;
    private String descricao;
    private MarcaDTO marca;
}


