package com.alljava.control.service;

import com.alljava.control.DTO.ModeloDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import com.alljava.control.repository.MarcaRepository;
import com.alljava.control.repository.ModeloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ModeloDTO salvar(ModeloDTO modeloDTO){
        Modelo entity = modeloRepository.save(modeloDTO.transformaParaObjeto());
        ModeloDTO dto = new ModeloDTO(entity);
        return dto;
    }

    public List<ModeloDTO> listaModelo(){
        return modeloRepository.findAll()
                .stream()
                .map(this::converterEntitiestoDTO)
                .collect(Collectors.toList());
    }
    public List<ModeloDTO> listaModeloMarca(Long id) {
        return marcaRepository.findModelosByMarcaId(id);
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
}
