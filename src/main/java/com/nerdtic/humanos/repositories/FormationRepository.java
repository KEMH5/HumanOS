package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
}
