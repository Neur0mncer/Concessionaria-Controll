package com.alljava.control.controllers;

import com.alljava.control.DTO.MarcaDTO;
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
    public MarcaDTO insert(@RequestBody MarcaDTO marcaDTO){
        return marcaService.salvar(marcaDTO);
    }

    @GetMapping
    public List<MarcaDTO> findAll(){
        return marcaService.listaMarca();
    }

    @GetMapping(value = "/{id}")
    public MarcaDTO findById(@PathVariable Long id){
        return marcaService.buscarId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca Não encontrada"));
    }


    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        marcaService.buscarId(id)
                .map(marcaDTO -> {
                    marcaService.removerId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca Não encontrada"));
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody MarcaDTO marca){
      marcaService.update(id, marca);
    }
}
