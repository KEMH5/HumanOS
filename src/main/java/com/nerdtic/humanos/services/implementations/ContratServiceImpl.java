package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.ContratCreateRequest;
import com.nerdtic.humanos.entities.Contrat;
import com.nerdtic.humanos.repositories.ContratRepository;
import com.nerdtic.humanos.repositories.PosteRepository;
import com.nerdtic.humanos.repositories.TypeContratRepository;
import com.nerdtic.humanos.security.entities.User;
import com.nerdtic.humanos.security.repositories.UserRepository;
import com.nerdtic.humanos.services.ContratService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {
    private final TypeContratRepository typeContratRepository;
    private final PosteRepository posteRepository;
    private final ContratRepository contratRepo;
    private final UserRepository userRepository;

    public ContratServiceImpl(TypeContratRepository typeContratRepository, PosteRepository posteRepository, ContratRepository contratRepo, UserRepository userRepository) {
        this.typeContratRepository = typeContratRepository;
        this.posteRepository = posteRepository;
        this.contratRepo = contratRepo;
        this.userRepository = userRepository;
    }

    @Override
    public Contrat saveContrat(
            ContratCreateRequest createRequest
    ) {
        var typeContrat = typeContratRepository.findById(
                createRequest.getIdTypeContrat()
        ).orElseThrow(() -> new RuntimeException("Type contrat introuvable"));

        var poste = posteRepository.findById(
                createRequest.getIdPoste()
        ).orElseThrow(() -> new RuntimeException("Poste introuvable"));

        var user = userRepository.findById(
                createRequest.getIdUser()
        ).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        var contrat = new Contrat();

        contrat.setDateDebut(createRequest.getDateDebut());
        contrat.setDateFin(createRequest.getDateFin());
        contrat.setDescription(createRequest.getDescription());
        contrat.setTypeContrat(typeContrat);
        contrat.setPoste(poste);
        contrat.setUser(user);

        return contratRepo.save(contrat);
    }

    @Override
    public Contrat getContrat(
            Long id
    ) {
        return contratRepo.findById(id)
                .orElse(null);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepo.findAll();
    }

    @Override
    public void deleteContrat(Long id) {
         contratRepo.deleteById(id);
    }

}
