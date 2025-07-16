package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongeRepository extends JpaRepository<Conge, Integer> {
}
