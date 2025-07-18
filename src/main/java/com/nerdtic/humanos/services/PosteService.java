package com.nerdtic.humanos.services;


import com.nerdtic.humanos.entities.Poste;

import java.util.List;

public interface PosteService {
    Poste createPoste(Poste poste);
    Poste getPoste(Integer id);
    List<Poste> getAllPostes();
    void deletePoste(Integer id);
}
