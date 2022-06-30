package com.alljava.control.entities;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) private long id;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
}
