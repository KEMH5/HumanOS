package com.nerdtic.humanos.conge;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CongeRepository extends JpaRepository<Conge, Long> {
    Optional<Conge> findByTypeConge(String typeConge);
}
