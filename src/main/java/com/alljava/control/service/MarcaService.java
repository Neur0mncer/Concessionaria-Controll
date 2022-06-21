package com.alljava.control.service;

import com.alljava.control.DTO.ConcessionariaDTO;
import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.entities.Concessionaria;
import com.alljava.control.entities.Marca;
import com.alljava.control.repository.MarcaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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


    public MarcaDTO salvar(Marca marca){
        return converterEntitiestoDTO(marcaRepository.save(marca));
    }
    public void update(Long id, MarcaDTO marcaDTO){
        marcaRepository.findById(id)
                .map(marcaBase -> {
                    modelMapper.map(marcaDTO, marcaBase);
                    marcaRepository.save(marcaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));

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
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO = modelMapper.map(marca, MarcaDTO.class);
        return marcaDTO;
    }

    private Marca converterDTOtoEntities(MarcaDTO marcaDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Marca marca = new Marca();
        marca = modelMapper.map(marcaDTO, Marca.class);
        return marca;
    }
}
