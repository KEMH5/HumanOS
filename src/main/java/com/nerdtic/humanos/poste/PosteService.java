package com.nerdtic.humanos.poste;


import java.util.List;

public interface PosteService {
    Poste createPoste(PosteCreateRequest createRequest);
    Poste getPoste(Long id);
    List<Poste> getAllPostes();
    void deletePoste(Long id);
}
