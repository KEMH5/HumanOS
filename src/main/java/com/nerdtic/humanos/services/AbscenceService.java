package com.nerdtic.humanos.services;

import com.nerdtic.humanos.dto.AbscenceCreateRequest;
import com.nerdtic.humanos.entities.Abscence;

import java.util.List;


public interface AbscenceService {
    Abscence createAbscence(AbscenceCreateRequest createRequest);
    List<Abscence> findAllAbscences();
    void deleteAbscence(Long abscenceId);
}
