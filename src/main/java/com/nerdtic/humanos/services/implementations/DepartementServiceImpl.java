package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.DepartementCreateRequest;
import com.nerdtic.humanos.entities.Departement;
import com.nerdtic.humanos.repositories.DepartementRepository;
import com.nerdtic.humanos.repositories.FormationRepository;
import com.nerdtic.humanos.services.DepartementService;
import org.springframework.stereotype.Service;

@Service
public class DepartementServiceImpl implements DepartementService {
    private final DepartementRepository departementRepository;
    private final FormationRepository formationRepository;

    public DepartementServiceImpl(DepartementRepository departementRepository, FormationRepository formationRepository) {
        this.departementRepository = departementRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public Departement createDepartement(
            DepartementCreateRequest createRequest
    ) {
        var formation = formationRepository.findById(
                createRequest.getIdFormation()).
                orElseThrow(() ->new RuntimeException("Formation introuvable"));


        var departement = new Departement();

        departement.setNomDepartement(createRequest.getNomDepartement());
        departement.getFormations().add(formation);

        return departementRepository.save(departement);
    }
}
