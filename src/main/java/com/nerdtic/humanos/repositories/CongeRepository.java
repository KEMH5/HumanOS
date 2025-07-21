package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CongeRepository extends JpaRepository<Conge, Long> {
    Optional<Conge> findByTypeConge(String typeConge);
}
