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

    Modelo modelo = new Modelo();
    Marca marca = new Marca();

    @Test
    void salvarModeloComSucesso() {
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        modelo.setDescricao("Onix");
        modelo.setMarca(marca);
        modeloRepository.save(modelo);
        assertNotNull(modelo.getId());
        assertNotNull(modelo.getDescricao());
        assertFalse(modelo.getDescricao().equals(" "));
    }

    @Test
    void atualizarModeloComSucesso() {
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

    @Test
    void listarTodasOsModelosComSucesso(){
        Modelo modelo1 = new Modelo();
        Marca marca1 = new Marca();
        marca.setDescricao("Chevrolet");
        marca1.setDescricao("Fiat");
        marcaRepository.save(marca);
        marcaRepository.save(marca1);
        modelo.setDescricao("Onix");
        modelo1.setDescricao("Fiat Touro");
        modelo.setMarca(marca);
        modelo1.setMarca(marca1);
        modeloRepository.save(modelo);
        modeloRepository.save(modelo1);
        assertTrue(modeloRepository.findAll().size() == 2);
        assertTrue(modeloRepository.findAll().get(0).getDescricao().equals("Onix"));
        assertTrue(modeloRepository.findAll().get(1).getDescricao().equals("Fiat Touro"));
    }

    @Test
    void excluirModeloComSucesso() {
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        modelo.setDescricao("Onix");
        modelo.setMarca(marca);
        modeloRepository.save(modelo);
        assertTrue(modeloRepository.count() == 1);
        modeloRepository.delete(modelo);
        assertTrue(modeloRepository.count() == 0);
    }

}