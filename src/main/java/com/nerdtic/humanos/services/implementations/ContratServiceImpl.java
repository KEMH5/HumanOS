package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Contrat;
import com.nerdtic.humanos.repositories.ContratRepository;
import com.nerdtic.humanos.security.entities.User;
import com.nerdtic.humanos.services.ContratService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {

    private final ContratRepository contratRepo;

    public ContratServiceImpl(ContratRepository contratRepo) {
        this.contratRepo = contratRepo;
    }

    @Override
    public Contrat saveContrat(Contrat contrat) {
        return contratRepo.save(contrat);
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
