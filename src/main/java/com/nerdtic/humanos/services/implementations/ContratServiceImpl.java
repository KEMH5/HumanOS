package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Contrat;
import com.nerdtic.humanos.repositories.ContratRepository;
import com.nerdtic.humanos.services.ContratService;

import java.util.List;

public class ContratServiceImpl implements ContratService {

    private ContratRepository contratRepo;

    @Override
    public Contrat saveContrat(Contrat contrat) {
        contratRepo.save(contrat);
        return contrat;
    }

    @Override
    public Contrat getContrat(
            Integer id
    ) {
        return contratRepo.findById(id)
                .orElse(null);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepo.findAll();
    }

    @Override
    public void deleteContrat(Integer id) {
         contratRepo.deleteById(id);
    }
}
