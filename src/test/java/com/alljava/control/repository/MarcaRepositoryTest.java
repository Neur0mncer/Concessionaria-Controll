package com.alljava.control.repository;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.service.MarcaService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarcaRepositoryTest {
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Test
    void salvarMarcaComSucesso() {
        Marca marca = new Marca();
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        assertNotNull(marca.getId());
        assertNotNull(marca.getDescricao());
        assertFalse(marca.getDescricao().equals(" "));
    }
     @Test
    void atualizarMarcaComSucesso(){
         Marca marca = new Marca();
         marca.setDescricao("Chevrolet");
         marcaRepository.save(marca);
         marca.setDescricao("Fiat");
         marcaRepository.save(marca);
         assertTrue(marca.getDescricao().equals("Fiat"));
     }

     @Test
    void listarTodasAsMarcasComSucesso(){
        Marca marca = new Marca();
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
        Marca marca = new Marca();
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        marcaRepository.delete(marca);
        assertFalse(marcaRepository.findById(1L).isPresent());
     }
}