package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.TypeContrat;

import java.util.List;
import java.util.Optional;

public interface TypeContratService {
    TypeContrat save(TypeContrat typeContrat);
    TypeContrat getTypeContratById(Integer id);
    List<TypeContrat> getAllTypeContrats();
    void deleteTypeContratById(Integer id);
    List<TypeContrat> getAllTypeContratByName(String name);
}
