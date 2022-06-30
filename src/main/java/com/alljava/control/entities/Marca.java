package com.alljava.control.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
