package com.alljava.control.repository;

import com.alljava.control.entities.Concessionaria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConcessionariaRepositoryTest {

    @Autowired
    ConcessionariaRepository concessionariaRepository;

    @Test
    void verificarSePossuiIdEseOsCamposSãoNulosOuVazios() {
        Concessionaria concessionaria = new Concessionaria();
        concessionaria.setNome("Peças Mendes");
        concessionaria.setCidade("Belo Horizonte");
        concessionaria.setTelefone("933778996");
        concessionaria.setEmail("pecasmendes@gmail.com");
        concessionariaRepository.save(concessionaria);
        assertNotNull(concessionaria.getId());
        assertNotNull(concessionaria.getNome());
        assertNotNull(concessionaria.getCidade());
        assertNotNull(concessionaria.getTelefone());
        assertFalse(concessionaria.getNome() == " ");
        assertFalse(concessionaria.getCidade() == " ");
        assertFalse(concessionaria.getTelefone() == " ");
        assertFalse(concessionaria.getEmail() == " ");
    }

}