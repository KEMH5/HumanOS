package com.nerdtic.humanos.contrat;

import java.util.List;

public interface ContratService {
    Contrat saveContrat(ContratCreateRequest createRequest);

    Contrat getContrat(Long id);

    List<Contrat> getAllContrats();

    void deleteContrat(Long id);
}
