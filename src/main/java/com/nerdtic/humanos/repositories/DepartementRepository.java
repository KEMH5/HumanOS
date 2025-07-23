package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
