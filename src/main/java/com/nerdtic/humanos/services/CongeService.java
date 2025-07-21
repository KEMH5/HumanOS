package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Conge;

import java.util.List;

public interface CongeService {

    List<Conge> getAllConge();

    Conge createConge(Conge conge);

    Conge updateConge(Conge conge, Long id);

    void deleteConge(Long id);

    Conge getConge(Long id);

}
