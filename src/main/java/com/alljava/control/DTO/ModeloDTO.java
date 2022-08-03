package com.alljava.control.DTO;

import com.alljava.control.validation.constrainst.MarcaDTOV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModeloDTO {

    private long id;
    @NotBlank(message = "Este campo é obrigatório")
    @Size(max = 100)
    private String descricao;
    @MarcaDTOV
    private MarcaDTO marca;
}


