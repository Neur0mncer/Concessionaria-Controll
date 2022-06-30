package com.alljava.control.DTO;

import com.alljava.control.entities.Concessionaria;
import com.alljava.control.entities.Marca;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConcessionariaDTO implements Serializable {

    private long id;
    private String nome;
    private String cidade;
    private String telefone;
    private String email;

    public ConcessionariaDTO(Concessionaria concessionaria) {
        id = concessionaria.getId();
        nome = concessionaria.getNome();
        cidade = concessionaria.getCidade();
        telefone = concessionaria.getTelefone();
        email = concessionaria.getEmail();
    }

    public Concessionaria transformaParaObjeto(){
        return new Concessionaria(id, nome, cidade, telefone, email);
    }

}
