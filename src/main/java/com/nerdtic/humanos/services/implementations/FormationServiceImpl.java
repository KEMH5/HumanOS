package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.FormationCreateRequest;
import com.nerdtic.humanos.entities.Formation;
import com.nerdtic.humanos.exception.DepartementNotFoundException;
import com.nerdtic.humanos.exception.FormationAlreadyExistsException;
import com.nerdtic.humanos.exception.FormationNotFoundException;
import com.nerdtic.humanos.repositories.DepartementRepository;
import com.nerdtic.humanos.repositories.FormationRepository;
import com.nerdtic.humanos.services.FormationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final DepartementRepository departementRepository;
    
    public FormationServiceImpl(FormationRepository formationRepository, DepartementRepository departementRepository) {
        this.formationRepository = formationRepository;
        this.departementRepository = departementRepository;
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation createFormation(FormationCreateRequest createRequest) {

        var departement = departementRepository.findById(createRequest.getIdDepartement())
                .orElseThrow(() -> new DepartementNotFoundException("Departement not found"));

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
        formation.getDepartements().add(departement);

        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(FormationCreateRequest createRequest, Long id) {
            
        var formation = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFoundException("Formation not found"));
        
        var departement = departementRepository.findById(createRequest.getIdDepartement())
                .orElseThrow(() -> new DepartementNotFoundException("Departement not found"));

        formation.setTitre(createRequest.getTitre());
        formation.setDescription(createRequest.getDescription());
        formation.setType(createRequest.getType());
        formation.setCout(createRequest.getCout());
        formation.setDateDebut(createRequest.getDateDebut());
        formation.setDateFin(createRequest.getDateFin());
        formation.setDomaine(createRequest.getDomaine());
        formation.setStatut(createRequest.getStatut());
        formation.setDuree(createRequest.getDuree());
        formation.getDepartements().add(departement);
        formation.getDepartements().remove(departement);

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