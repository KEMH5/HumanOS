package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.FormationCreateRequest;
import com.nerdtic.humanos.entities.Formation;
import com.nerdtic.humanos.exception.DepartementNotFoundException;
import com.nerdtic.humanos.exception.FormationAlreadyExistsException;
import com.nerdtic.humanos.exception.FormationNotFoundException;
import com.nerdtic.humanos.repositories.DepartementRepository;
import com.nerdtic.humanos.repositories.FormationRepository;
import com.nerdtic.humanos.security.repositories.UserRepository;
import com.nerdtic.humanos.services.FormationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final DepartementRepository departementRepository;
    private final UserRepository userRepository;

    public FormationServiceImpl(FormationRepository formationRepository, DepartementRepository departementRepository, UserRepository userRepository) {
        this.formationRepository = formationRepository;
        this.departementRepository = departementRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation createFormation(FormationCreateRequest createRequest) {

        var user = userRepository.findById(createRequest.getIdUser())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var formation = new Formation();

        formation.setTitre(createRequest.getTitre());
        formation.setDescription(createRequest.getDescription());
        formation.setType(createRequest.getType());
        formation.setCout(createRequest.getCout());
        formation.setDateDebut(createRequest.getDateDebut());
        formation.setDateFin(createRequest.getDateFin());
        formation.setDomaine(createRequest.getDomaine());
        formation.setStatut(createRequest.getStatut());
        formation.setDuree(createRequest.getDuree());
        formation.getUsers().add(user);

        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(FormationCreateRequest createRequest, Long id) {
            
        var formation = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFoundException("Formation not found"));
        
        var user = userRepository.findById(createRequest.getIdUser())
                .orElseThrow(() -> new RuntimeException("User not found"));

        formation.setTitre(createRequest.getTitre());
        formation.setDescription(createRequest.getDescription());
        formation.setType(createRequest.getType());
        formation.setCout(createRequest.getCout());
        formation.setDateDebut(createRequest.getDateDebut());
        formation.setDateFin(createRequest.getDateFin());
        formation.setDomaine(createRequest.getDomaine());
        formation.setStatut(createRequest.getStatut());
        formation.setDuree(createRequest.getDuree());
        formation.getUsers().add(user);
        formation.getUsers().remove(user);

        return formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(Long id) {
        var formation = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFoundException("Formation not found"));
        formationRepository.delete(formation);
    }

    @Override
    public Formation getFormationById(Long id) {
        Optional<Formation> formation = formationRepository.findById(id);

        if(formation.isPresent()){
            return formation.get();
        }
        else {
            throw new FormationNotFoundException("Formation Not Found");
        }
    }
}