package com.alljava.control.controllers;

import com.alljava.control.DTO.ConcessionariaDTO;
import com.alljava.control.service.ConcessionariaService;
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
   private ConcessionariaService concessionariaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ConcessionariaDTO insert(@RequestBody ConcessionariaDTO concessionariaDTO){
        return concessionariaService.salvar(concessionariaDTO);
    }

    @GetMapping
    public List<ConcessionariaDTO> findAll(){
        return concessionariaService.listaConcessionaria();
    }

    @GetMapping(value = "/{id}")
    public ConcessionariaDTO findById(@PathVariable Long id){
        return concessionariaService.buscarId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        concessionariaService.buscarId(id)
                .map(concessionariaDTO -> {
                   concessionariaService.removerId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));

    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody ConcessionariaDTO concessionaria){
        concessionariaService.update(id, concessionaria);
    }
}

