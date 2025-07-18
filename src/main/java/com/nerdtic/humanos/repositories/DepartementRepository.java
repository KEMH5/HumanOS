package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    Optional<Departement> findByNomDepartement(String nomDepartement);
}
