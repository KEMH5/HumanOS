package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.PosteCreateRequest;
import com.nerdtic.humanos.entities.Poste;
import com.nerdtic.humanos.repositories.ContratRepository;
import com.nerdtic.humanos.repositories.PosteRepository;
import com.nerdtic.humanos.services.PosteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteServiceImpl implements PosteService {
    private final PosteRepository posteRepository;
    private final ContratRepository contratRepository;

    public PosteServiceImpl(PosteRepository posteRepository, ContratRepository contratRepository) {
        this.posteRepository = posteRepository;
        this.contratRepository = contratRepository;
    }

    @Override
    public Poste createPoste(
            PosteCreateRequest createRequest
    ) {
        var poste = new Poste();

        poste.setTitle(createRequest.getTitle());
        poste.setDescription(createRequest.getDescription());

        return posteRepository.save(poste);
    }

    @Override
    public Poste getPoste(
            Long id
    ) {
        return posteRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @Override
    public void deletePoste(Long id) {
        posteRepository.deleteById(id);
    }
}
