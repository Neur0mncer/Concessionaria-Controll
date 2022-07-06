package com.alljava.control.service;

import com.alljava.control.DTO.ConcessionariaDTO;
import com.alljava.control.DTO.ModeloDTO;
import com.alljava.control.entities.Concessionaria;
import com.alljava.control.entities.Modelo;
import com.alljava.control.repository.ConcessionariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConcessionariaService {

    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ConcessionariaDTO salvar(ConcessionariaDTO concessionariaDTO){
        Concessionaria entity = concessionariaRepository.save(concessionariaDTO.transformaParaObjeto());
        ConcessionariaDTO dto = new ConcessionariaDTO(entity);
        return dto;
    }

    public void update(Long id, ConcessionariaDTO concessionaria){
        concessionariaRepository.findById(id)
                .map(concessionariaBase -> {
                    modelMapper.map(concessionaria, concessionariaBase);
                    concessionariaRepository.save(concessionariaBase);
                    return concessionaria;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concessionaria Não encontrada"));
    }

    public List<ConcessionariaDTO> listaConcessionaria(){
        return concessionariaRepository.findAll()
                .stream()
                .map(this::converterEntitiestoDTO)
                .collect(Collectors.toList());
    }

    public Optional<ConcessionariaDTO> buscarId(Long id){
        return concessionariaRepository.findById(id)
                .map(this::converterEntitiestoDTO);
    }

    public void removerId(Long id){
        concessionariaRepository.deleteById(id);
    }

    private ConcessionariaDTO converterEntitiestoDTO(Concessionaria concessionaria){
        ConcessionariaDTO concessionariaDTO = modelMapper.map(concessionaria, ConcessionariaDTO.class);
        return concessionariaDTO;
    }

}
