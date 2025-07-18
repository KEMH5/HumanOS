package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Poste;
import com.nerdtic.humanos.repositories.PosteRepository;
import com.nerdtic.humanos.services.PosteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteServiceImpl implements PosteService {
    private final PosteRepository posteRepository;

    public PosteServiceImpl(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    @Override
    public Poste createPoste(
            Poste poste
    ) {
        return posteRepository.save(poste);
    }

    @Override
    public Poste getPoste(
            Integer id
    ) {
        return posteRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @Override
    public void deletePoste(Integer id) {
        posteRepository.deleteById(id);
    }
}
