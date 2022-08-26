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

    Concessionaria concessionaria = new Concessionaria();

    @Test
    void salvarConcessionariaComSucesso() {
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

    @Test
    void listarTodasAsConcessionariasComSucesso() {
        concessionaria.setNome("AutoPeças");
        concessionaria.setCidade("São Paulo");
        concessionaria.setTelefone("986773455");
        concessionaria.setEmail("autopeças@gmail.com");
        concessionariaRepository.save(concessionaria);
        Concessionaria concessionaria1 = new Concessionaria();
        concessionaria1.setNome("Peças Mendes");
        concessionaria1.setCidade("Belo Horizonte");
        concessionaria1.setTelefone("933778996");
        concessionaria1.setEmail("pecasmendes@gmail.com");
        concessionariaRepository.save(concessionaria1);
        assertTrue(concessionariaRepository.findAll().size() == 2);
        assertTrue(concessionariaRepository.findAll().get(0).getNome().equals("AutoPeças"));
        assertTrue(concessionariaRepository.findAll().get(1).getNome().equals("Peças Mendes"));
    }

    @Test
    void excluirConcessionariaComSucesso() {
        concessionaria.setNome("Peças Mendes");
        concessionaria.setCidade("Belo Horizonte");
        concessionaria.setTelefone("933778996");
        concessionaria.setEmail("pecasmendes@gmail.com");
        concessionariaRepository.save(concessionaria);
        assertTrue(concessionariaRepository.count() == 1);
        concessionariaRepository.delete(concessionaria);
        assertTrue(concessionariaRepository.count() == 0);
    }

}