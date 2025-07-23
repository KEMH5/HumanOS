package com.nerdtic.humanos.services;


import com.nerdtic.humanos.dto.PosteCreateRequest;
import com.nerdtic.humanos.entities.Poste;

import java.util.List;

public interface PosteService {
    Poste createPoste(PosteCreateRequest createRequest);
    Poste getPoste(Long id);
    List<Poste> getAllPostes();
    void deletePoste(Long id);
}
