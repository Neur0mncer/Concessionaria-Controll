package com.alljava.control.repository;

import com.alljava.control.entities.Marca;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MarcaRepositoryTest {
    @Autowired
    private MarcaRepository marcaRepository;

    @Test
    void verificarSePossuiIdEDescricaoNaoNulaOuVazia() {
        Marca marca = new Marca();
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        assertNotNull(marca.getId());
        assertNotNull(marca.getDescricao());
        assertFalse(marca.getDescricao() == " ");
    }
}