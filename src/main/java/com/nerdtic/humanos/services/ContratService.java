package com.nerdtic.humanos.services;
import com.nerdtic.humanos.entities.Contrat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContratService {
    Contrat saveContrat(Contrat contrat);

    Contrat getContrat(Integer id);

    List<Contrat> getAllContrats();

    void deleteContrat(Integer id);
}
