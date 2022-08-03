package com.alljava.control.entities;

import com.alljava.control.validation.constrainst.MarcaDTOV;
import com.alljava.control.validation.constrainst.MarcaV;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @NotBlank(message = "Este campo é obrigatório")
    @Size(max = 100)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    @MarcaV
    private Marca marca;

}
