package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Paie;

import java.util.List;

public interface PaieService {
    Paie createPaie(Paie paie);
    Paie getPaie(Integer id);
    List<Paie> getPaies();
    void deletePaie(Integer id);
}
