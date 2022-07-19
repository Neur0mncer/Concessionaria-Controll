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

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO {
    private long id;
    private String descricao;
    @JsonIgnore
    private List<ModeloDTO> modelos;

}
