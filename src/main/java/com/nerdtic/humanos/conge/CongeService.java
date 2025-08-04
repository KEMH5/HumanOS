package com.nerdtic.humanos.conge;

import java.util.List;

public interface CongeService {

    List<Conge> getAllConge();

    Conge createConge(Conge conge);

    Conge updateConge(Conge conge, Long id);

    void deleteConge(Long id);

    Conge getConge(Long id);

}
