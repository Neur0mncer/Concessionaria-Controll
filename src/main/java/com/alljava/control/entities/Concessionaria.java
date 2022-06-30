package com.alljava.control.entities;

import lombok.*;

import javax.persistence.*;
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

    @Column (name = "name", nullable = false)
    private String nome;
    @Column (name = "cidade")
    private String cidade;
    @Column (name = "telefone")
    private String telefone;
    @Column (name = "email")
    private String email;

}
