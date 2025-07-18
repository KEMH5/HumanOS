package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Paie;
import com.nerdtic.humanos.repositories.PaieRepository;
import com.nerdtic.humanos.services.PaieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaieServiceImpl implements PaieService {
    private PaieRepository paieRepository;

    public PaieServiceImpl(PaieRepository paieRepository) {
        this.paieRepository = paieRepository;
    }

    @Override
    public Paie createPaie(
            Paie paie
    ) {
        return paieRepository.save(paie);
    }

    @Override
    public Paie getPaie(
            Integer id
    ) {
        return paieRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Paie> getPaies() {
        return paieRepository.findAll();
    }

    @Override
    public void deletePaie(
            Integer id
    ) {
        paieRepository.deleteById(id);
    }
}
