package com.alljava.control.service;

import com.alljava.control.DTO.ModeloDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import com.alljava.control.repository.ModeloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ModeloDTO salvar(Modelo modelo){
        return converterEntitiestoDTO(modeloRepository.save(modelo));
    }

    public List<ModeloDTO> listaModelo(){
        return modeloRepository.findAll()
                .stream()
                .map(this::converterEntitiestoDTO)
                .collect(Collectors.toList());
    }
    public List<ModeloDTO> listaModeloMarca(Marca marca) {
        return marca.getModelos()
                .stream()
                .map(this::converterEntitiestoDTO)
                .collect(Collectors.toList());
    }
    public Optional<ModeloDTO> buscarId(Long id){
        return modeloRepository.findById(id)
                .map(this::converterEntitiestoDTO);
    }

    public void removerId(Long id){
        modeloRepository.deleteById(id);
    }

    public void update(Long id, ModeloDTO modeloDTO){
        modeloRepository.findById(id)
                .map(modeloBase ->{
                    modelMapper.map(modeloDTO, modeloBase);
                    modeloRepository.save(modeloBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo Não encontrado"));
    }

    private ModeloDTO converterEntitiestoDTO(Modelo modelo){
        ModeloDTO modeloDTO = modelMapper.map(modelo, ModeloDTO.class);
        return modeloDTO;
    }

    private Modelo converterDTOtoEntities(ModeloDTO modeloDTO){
        Modelo modelo = modelMapper.map(modeloDTO, Modelo.class);
        return modelo;
    }
}
