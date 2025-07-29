package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.DepartementCreateRequest;
import com.nerdtic.humanos.entities.Departement;
import com.nerdtic.humanos.exception.DepartementNotFoundException;
import com.nerdtic.humanos.exception.FormationNotFoundException;
import com.nerdtic.humanos.repositories.DepartementRepository;
import com.nerdtic.humanos.repositories.FormationRepository;
import com.nerdtic.humanos.services.DepartementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImpl implements DepartementService {
    private final DepartementRepository departementRepository;
    private final FormationRepository formationRepository;

    public DepartementServiceImpl(DepartementRepository departementRepository, FormationRepository formationRepository) {
        this.departementRepository = departementRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public Departement createDepartement(DepartementCreateRequest createRequest) {
        var departement = new Departement();
        departement.setNomDepartement(createRequest.getNomDepartement());
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement updateDepartement(DepartementCreateRequest createRequest, Long id) {

        var departement = departementRepository.findById(id)
                .orElseThrow(() ->new DepartementNotFoundException("Departement not found"));

        var formation = formationRepository.findById(createRequest.getIdFormation())
                .orElseThrow(() ->new FormationNotFoundException("Formation not found"));

        departement.setNomDepartement(createRequest.getNomDepartement());
        departement.getFormations().add(formation);
        departement.getFormations().remove(formation);

        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(Long id) {
        var departement = departementRepository.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException("Departement not found"));

        departementRepository.delete(departement);
    }

    @Override
    public Departement getDepartement(Long id) {

        var departement = departementRepository.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException("Departement not found"));
        return departement;
    }
}
