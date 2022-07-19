package com.alljava.control.repository;


import com.alljava.control.DTO.ConcessionariaDTO;
import com.alljava.control.DTO.MarcaDTO;
import com.alljava.control.DTO.ModeloDTO;
import com.alljava.control.entities.Marca;
import com.alljava.control.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {


    @Query(value = "SELECT u FROM Modelo u WHERE u.marca.id = ?1")
    List<Modelo> findModelosByMarcaId(Long marca);

}
