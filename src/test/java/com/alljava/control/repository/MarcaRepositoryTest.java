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
    void verificarSePossuiIdEDescricaoNaoNulaOuVazia() {
        Marca marca = new Marca();
        marca.setDescricao("Chevrolet");
        marcaRepository.save(marca);
        assertNotNull(marca.getId());
        assertNotNull(marca.getDescricao());
        assertFalse(marca.getDescricao() == " ");
    }
     @Test
    void verificarSeEstaAtualizando(){
         Marca marca = new Marca();
         Marca marca1 = new Marca();
         marca.setDescricao("Chevrolet");
         marca1.setDescricao("Peugeot");
         marcaRepository.save(marca);
         modelMapper.map(marca1, marca);
         marcaRepository.save(marca);
         assertTrue(marca.getDescricao() == "Peugeot");
     }
}