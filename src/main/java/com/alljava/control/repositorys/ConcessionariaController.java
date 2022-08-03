package com.alljava.control.repositorys;

import com.alljava.control.DTO.ConcessionariaDTO;
import com.alljava.control.service.ConcessionariaService;
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
@RequestMapping(value = "/concessionaria")
public class ConcessionariaController {

    @Autowired
   private ConcessionariaService concessionariaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ConcessionariaDTO insert(@RequestBody @Valid ConcessionariaDTO concessionariaDTO){
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

