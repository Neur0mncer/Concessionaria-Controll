package com.alljava.control.repository;


import com.alljava.control.DTO.ConcessionariaDTO;
import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
