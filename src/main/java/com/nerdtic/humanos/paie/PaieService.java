package com.nerdtic.humanos.paie;

import java.util.List;

public interface PaieService {
    Paie createPaie(PaieCreateRequest createRequest);
    Paie getPaie(Long id);
    List<Paie> getPaies();
    void deletePaie(Long id);
}
