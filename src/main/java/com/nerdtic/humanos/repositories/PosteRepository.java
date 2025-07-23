package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosteRepository extends JpaRepository<Poste, Long> {
}
