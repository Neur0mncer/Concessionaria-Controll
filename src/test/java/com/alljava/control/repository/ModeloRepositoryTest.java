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
    void salvarModeloComSucesso() {
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
    void atualizarModeloComSucesso() {
        Modelo modelo = new Modelo();
        Marca marca = new Marca();
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        modelo.setDescricao("Onix");
        modelo.setMarca(marca);
        modeloRepository.save(modelo);
        marca.setDescricao("Fiat");
        marcaRepository.save(marca);
        modelo.setDescricao("Fiat Touro");
        modeloRepository.save(modelo);
        assertTrue(modelo.getDescricao().equals("Fiat Touro"));
        assertTrue(modelo.getMarca().getDescricao().equals("Fiat"));

    }

}