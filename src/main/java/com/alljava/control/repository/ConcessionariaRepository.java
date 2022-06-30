package com.alljava.control.repository;

import com.alljava.control.DTO.ConcessionariaDTO;
import com.alljava.control.entities.Concessionaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {

}
