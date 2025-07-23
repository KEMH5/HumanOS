package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeContratRepository extends JpaRepository<TypeContrat, Long> {
    List<TypeContrat> findAllByNameContaining(String name);
}
