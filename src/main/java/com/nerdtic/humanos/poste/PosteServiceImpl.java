package com.nerdtic.humanos.poste;

import com.nerdtic.humanos.contrat.ContratRepository;
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
