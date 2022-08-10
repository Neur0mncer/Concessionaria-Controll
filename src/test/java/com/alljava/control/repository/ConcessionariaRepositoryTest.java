package com.alljava.control.repository;

import com.alljava.control.entities.Concessionaria;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConcessionariaRepositoryTest {

    @Autowired
    ConcessionariaRepository concessionariaRepository;
    @Autowired
    ModelMapper modelMapper;

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

    @Test
    void verificarSeEstaAtualizando() {
        Concessionaria concessionaria = new Concessionaria();
        Concessionaria concessionaria1 = new Concessionaria();
        concessionaria1.setNome("Peças Mendes");
        concessionaria1.setCidade("Belo Horizonte");
        concessionaria1.setTelefone("933778996");
        concessionaria1.setEmail("pecasmendes@gmail.com");
        concessionaria.setNome("AutoPeças");
        concessionaria.setCidade("São Paulo");
        concessionaria.setTelefone("986773455");
        concessionaria.setEmail("autopeças@gmail.com");
        concessionariaRepository.save(concessionaria);
        modelMapper.map(concessionaria1, concessionaria);
        assertTrue(concessionaria.getNome() == "Peças Mendes");
        assertTrue(concessionaria.getCidade() == "Belo Horizonte");
        assertTrue(concessionaria.getTelefone() == "933778996");
        assertTrue(concessionaria.getEmail() == "pecasmendes@gmail.com");


    }

}