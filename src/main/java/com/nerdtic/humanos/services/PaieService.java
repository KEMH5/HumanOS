package com.nerdtic.humanos.services;

import com.nerdtic.humanos.dto.PaieCreateRequest;
import com.nerdtic.humanos.entities.Paie;

import java.util.List;

public interface PaieService {
    Paie createPaie(PaieCreateRequest createRequest);
    Paie getPaie(Long id);
    List<Paie> getPaies();
    void deletePaie(Long id);
}
