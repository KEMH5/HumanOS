package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
    Optional<Formation> findByTitre(String titre);
}
