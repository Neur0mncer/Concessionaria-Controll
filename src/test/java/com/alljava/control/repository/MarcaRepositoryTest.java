package com.alljava.control.repository;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.service.MarcaService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarcaRepositoryTest {

    @Autowired
    private MarcaRepository marcaRepository;

    Marca marca = new Marca();

    @Test
    void salvarMarcaComSucesso() {
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        assertNotNull(marca.getId());
        assertNotNull(marca.getDescricao());
        assertFalse(marca.getDescricao().equals(" "));
    }
     @Test
    void atualizarMarcaComSucesso(){
         marca.setDescricao("Chevrolet");
         marcaRepository.save(marca);
         marca.setDescricao("Fiat");
         marcaRepository.save(marca);
         assertTrue(marca.getDescricao().equals("Fiat"));
     }

     @Test
    void listarTodasAsMarcasComSucesso(){
        Marca marca1 = new Marca();
        marca.setDescricao("Chevrolet");
        marca1.setDescricao("Fiat");
        marcaRepository.save(marca);
        marcaRepository.save(marca1);
        assertTrue(marcaRepository.findAll().size() == 2);
        assertTrue(marcaRepository.findAll().get(0).getDescricao().equals("Chevrolet"));
        assertTrue(marcaRepository.findAll().get(1).getDescricao().equals("Fiat"));
     }

     @Test
    void excluirMarcaComSucesso() {
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        assertTrue(marcaRepository.count() == 1);
        marcaRepository.delete(marca);
        assertTrue(marcaRepository.count() == 0);
     }
}