package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Abscence;

import java.util.List;


public interface AbscenceService {
    Abscence createAbscence(Abscence abscence);
    Abscence findAbscence(Integer abscenceId);
    List<Abscence> findAllAbscences();
    void deleteAbscence(Integer abscenceId);
}
