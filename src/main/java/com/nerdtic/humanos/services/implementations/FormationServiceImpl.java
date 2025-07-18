package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Formation;
import com.nerdtic.humanos.exception.FormationAlreadyExistsException;
import com.nerdtic.humanos.exception.FormationNotFoundException;
import com.nerdtic.humanos.repositories.FormationRepository;
import com.nerdtic.humanos.services.FormationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation createFormation(Formation formation) {

        if(formationRepository.findByTitre(formation.getTitre()).isPresent()){
           throw new FormationAlreadyExistsException("Formation already exists");
        }
        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(Formation formationDetails, int id) {
        Optional<Formation> formation = formationRepository.findById(id);

        if(formation.isPresent()){
            Formation formationToUpdate = formation.get();

            formationToUpdate.setTitre(formationDetails.getTitre());
            formationToUpdate.setDescription(formationDetails.getDescription());
            formationToUpdate.setType(formationDetails.getType());
            formationToUpdate.setDescription(formationDetails.getDescription());
            formationToUpdate.setCout(formationDetails.getCout());
            formationToUpdate.setDateDebut(formationDetails.getDateDebut());
            formationToUpdate.setDateFin(formationDetails.getDateFin());
            formationToUpdate.setStatut(formationDetails.getStatut());
            formationToUpdate.setDomaine(formationDetails.getDomaine());
            formationToUpdate.setDepartements(formationDetails.getDepartements());

            return formationRepository.save(formationToUpdate);

        }
        throw new FormationNotFoundException("Formation Not Found");
    }

    @Override
    public void deleteFormation(int id) {

        Optional<Formation> existingFormation = formationRepository.findById(id);
        if(existingFormation.isPresent()){
            formationRepository.deleteById(id);
        }
        throw new FormationNotFoundException("Formation Not Found");
    }

    @Override
    public Formation getFormationById(int id) {
        Optional<Formation> formation = formationRepository.findById(id);

        if(formation.isPresent()){
            return formation.get();
        }

        else {
            throw new FormationNotFoundException("Formation Not Found");
        }
    }
}
