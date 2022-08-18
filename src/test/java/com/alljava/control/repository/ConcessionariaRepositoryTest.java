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
    void salvarConcessionariaComSucesso() {
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
        assertFalse(concessionaria.getNome().equals(" "));
        assertFalse(concessionaria.getCidade().equals(" "));
        assertFalse(concessionaria.getTelefone().equals(" "));
        assertFalse(concessionaria.getEmail().equals(" "));
    }

    @Test
    void atualizarConcessionariaComSucesso() {
        Concessionaria concessionaria = new Concessionaria();
        concessionaria.setNome("AutoPeças");
        concessionaria.setCidade("São Paulo");
        concessionaria.setTelefone("986773455");
        concessionaria.setEmail("autopeças@gmail.com");
        concessionariaRepository.save(concessionaria);
        concessionaria.setNome("Peças Mendes");
        concessionaria.setCidade("Belo Horizonte");
        concessionaria.setTelefone("933778996");
        concessionaria.setEmail("pecasmendes@gmail.com");
        concessionariaRepository.save(concessionaria);
        assertTrue(concessionaria.getNome().equals("Peças Mendes"));
        assertTrue(concessionaria.getCidade().equals("Belo Horizonte"));
        assertTrue(concessionaria.getTelefone().equals("933778996"));
        assertTrue(concessionaria.getEmail().equals("pecasmendes@gmail.com"));
    }

}