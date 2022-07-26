package com.alljava.control.controllers;

import com.alljava.control.DTO.ModeloDTO;
import com.alljava.control.service.ModeloService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ModeloDTO insert(@RequestBody @Valid ModeloDTO modeloDTO){
        return modeloService.salvar(modeloDTO);
    }

    @GetMapping
    public List<ModeloDTO> findAll(){
        return modeloService.listaModelo();
    }

    @GetMapping(value = "/{id}")
    public ModeloDTO findById(@PathVariable Long id){
       return modeloService.buscarId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo Não encontrado"));
    }

    @GetMapping(value = "/listaMarca/{id}")
    public List<ModeloDTO> listaModeloMarca(@PathVariable Long id){
        return modeloService.listaModeloMarca(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        modeloService.buscarId(id)
                .map(modelo -> {
                    modeloService.removerId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo Não encontrado"));
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody ModeloDTO modelo){

        modeloService.update(id,modelo);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
