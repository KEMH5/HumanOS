package com.nerdtic.humanos.services;
import com.nerdtic.humanos.entities.Contrat;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContratService {
    Contrat saveContrat(Contrat contrat);

    Contrat getContrat(Long id);

    List<Contrat> getAllContrats();

    void deleteContrat(Long id);
}
