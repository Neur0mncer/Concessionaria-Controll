package com.alljava.control.repository;

import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ModeloRepositoryTest {

    @Autowired
    ModeloRepository modeloRepository;
    @Autowired
    MarcaRepository marcaRepository;
    @Autowired
    ModelMapper modelMapper;

    @Test
    void verificarSePossuiIdEDescricaoNaoNulaOuVazia() {
        Modelo modelo = new Modelo();
        Marca marca = new Marca();
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        modelo.setDescricao("Onix");
        modelo.setMarca(marca);
        modeloRepository.save(modelo);
        assertNotNull(modelo.getId());
        assertNotNull(modelo.getDescricao());
        assertFalse(modelo.getDescricao() == " ");
    }

    @Test
    void verificarSeEstaAtualizando() {
        Modelo modelo = new Modelo();
        Marca marca = new Marca();
        Modelo modelo1 = new Modelo();
        Marca marca1 = new Marca();
        marca.setDescricao("Chevrolet");
        marca1.setDescricao("Peugeot");
        marcaRepository.save(marca);
        marcaRepository.save(marca1);
        modelo.setDescricao("Onix");
        modelo.setMarca(marca);
        modelo1.setDescricao("Fiat Touro");
        modelo1.setMarca(marca1);
        modeloRepository.save(modelo);
        modelMapper.map(modelo1, modelo);
        modeloRepository.save(modelo);
        assertTrue(modelo.getDescricao() == "Fiat Touro");
        assertTrue(modelo.getMarca().getDescricao() == "Peugeot");

    }

}