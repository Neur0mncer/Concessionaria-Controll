package com.alljava.control.repositorys;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.service.MarcaService;
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
@RequestMapping(value = "/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public MarcaDTO insert(@RequestBody @Valid MarcaDTO marcaDTO){
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
