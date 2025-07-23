package com.nerdtic.humanos.services;
import com.nerdtic.humanos.dto.ContratCreateRequest;
import com.nerdtic.humanos.entities.Contrat;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContratService {
    Contrat saveContrat(ContratCreateRequest createRequest);

    Contrat getContrat(Long id);

    List<Contrat> getAllContrats();

    void deleteContrat(Long id);
}
