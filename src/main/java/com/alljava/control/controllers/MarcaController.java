package com.alljava.control.controllers;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.entities.Concessionaria;
import com.alljava.control.entities.Marca;
import com.alljava.control.repository.MarcaRepository;
import com.alljava.control.service.MarcaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public MarcaDTO insert(@RequestBody Marca marca){
        return marcaService.salvar(marca);
    }

    @GetMapping
    public List<MarcaDTO> findAll(){
        return marcaService.listaMarca();
    }

    @GetMapping(value = "/{id}")
    public MarcaDTO findById(@PathVariable Long id){
        return marcaService.buscarId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        marcaService.buscarId(id)
                .map(marca -> {
                    marcaService.removerId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));

    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody MarcaDTO marca){
      marcaService.update(id, marca);
    }



}
