package com.nerdtic.humanos.typeContrat;

import java.util.List;

public interface TypeContratService {
    TypeContrat save(TypeContrat typeContrat);
    TypeContrat getTypeContratById(Long id);
    List<TypeContrat> getAllTypeContrats();
    void deleteTypeContratById(Long id);
    List<TypeContrat> getAllTypeContratByName(String name);
}
