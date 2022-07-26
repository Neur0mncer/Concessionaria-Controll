package com.alljava.control.DTO;

import com.alljava.control.entities.Concessionaria;
import com.alljava.control.validation.constrainst.Telefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConcessionariaDTO implements Serializable {

    private long id;
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
