package com.alljava.control.controllers;

import com.alljava.control.DTO.MarcaDTO;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MarcaControllerTest {

    @Autowired
    private MarcaController marcaController;

    @Test
    void possuiId() {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setDescricao("Chevrolet");
        marcaController.insert(marcaDTO);
        assertNotNull(marcaDTO.getId());
    }

    @Test
    void descricaoNotNull() {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setDescricao("Chevrolet");
        marcaController.insert(marcaDTO);
        assertNotNull(marcaDTO.getDescricao());
    }

    @Test
    void descricaoNotEmpty() {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setDescricao("Chevrolet");
        marcaController.insert(marcaDTO);
        assertFalse(marcaDTO.getDescricao() == " ");
    }
}