package com.alljava.control.entities;

import com.alljava.control.validation.constrainst.Telefone;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_concessionaria")
public class Concessionaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) private long id;
    @NotBlank(message = "Este campo é obrigatório")
    @Size(max = 100)
    private String nome;
    @NotBlank(message = "Este campo é obrigatório")
    @Size(max = 100)
    private String cidade;
    @NotBlank(message = "Este campo é obrigatório")
    @Telefone
    private String telefone;
    @Nullable
    @Email
    private String email;
}
