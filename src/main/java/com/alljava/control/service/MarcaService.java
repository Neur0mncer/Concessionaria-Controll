package com.alljava.control.service;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.DTO.ModeloDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import com.alljava.control.repository.MarcaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModelMapper modelMapper;


    public MarcaDTO salvar(MarcaDTO marcaDTO){
        Marca entity = modelMapper.map(marcaDTO, Marca.class);
        List<Modelo> modelos = marcaRepository.findModelosByMarcaId(marcaDTO.getId());
        entity.setModelos(modelos);
        Marca entitySave = marcaRepository.save(entity);
        MarcaDTO dto = modelMapper.map(entitySave, MarcaDTO.class);
        return dto;
    }
    public void update(Long id, MarcaDTO marcaDTO){
        marcaRepository.findById(id)
                .map(marcaBase -> {
                    modelMapper.map(marcaDTO, marcaBase);
                    marcaRepository.save(marcaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca Não encontrada"));

    }


    public List<MarcaDTO> listaMarca(){
        return marcaRepository.findAll()
                .stream()
                .map(this::converterEntitiestoDTO)
                .collect(Collectors.toList());
    }

    public Optional<MarcaDTO> buscarId(Long id){
        return marcaRepository.findById(id)
                .map(this::converterEntitiestoDTO);
    }


    public void removerId(Long id){
        marcaRepository.deleteById(id);
    }

    private MarcaDTO converterEntitiestoDTO(Marca marca){
       MarcaDTO marcaDTO = modelMapper.map(marca, MarcaDTO.class);
        return marcaDTO;
    }

}
