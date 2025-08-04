package com.nerdtic.humanos.absence;

import java.util.List;


public interface AbscenceService {
    Abscence createAbscence(AbscenceCreateRequest createRequest);
    List<Abscence> findAllAbscences();
    void deleteAbscence(Long abscenceId);
}
