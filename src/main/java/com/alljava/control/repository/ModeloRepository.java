package com.alljava.control.repository;

import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.DTO.ModeloDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
