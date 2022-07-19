package com.alljava.control.entities;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.DTO.ModeloDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) private long id;
    private String descricao;
    @JsonIgnore
    @OneToMany(mappedBy = "marca",fetch = FetchType.LAZY)
    private List<Modelo> modelos;


}
