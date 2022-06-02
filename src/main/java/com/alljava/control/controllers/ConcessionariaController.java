package com.alljava.control.controllers;

import com.alljava.control.entities.Concessionaria;
import com.alljava.control.repository.ConcessionariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/concessionaria")
public class ConcessionariaController {

    @Autowired
    private ConcessionariaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Concessionaria insert(@RequestBody Concessionaria concessionaria){
        return repository.save(concessionaria);
    }

    @GetMapping
    public List<Concessionaria> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Concessionaria findById(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        repository.findById(id)
                .map(concessionaria -> {
                    repository.deleteById(concessionaria.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));

    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Concessionaria concessionaria){
        repository.findById(id)
                .map(concessionariaBase -> {
                   modelMapper.map(concessionaria, concessionariaBase);
                    repository.save(concessionariaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));

    }
}
