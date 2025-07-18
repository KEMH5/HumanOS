package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Conge;

import java.util.List;

public interface CongeService {

    List<Conge> getAllConge();

    Conge createConge(Conge conge);

    Conge updateConge(Conge conge, int id);

    void deleteConge(int id);

    Conge getConge(int id);

}
