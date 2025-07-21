package com.nerdtic.humanos.repositories;

import com.nerdtic.humanos.entities.Abscence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbscenceRepository extends JpaRepository<Abscence, Long> {
}
