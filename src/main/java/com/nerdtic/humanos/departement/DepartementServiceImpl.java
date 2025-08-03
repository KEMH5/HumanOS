package com.nerdtic.humanos.departement;

import com.nerdtic.humanos.exception.DepartementNotFoundException;
import com.nerdtic.humanos.formation.FormationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<DepartementReadRequest> getAllDepartements(){
        return departementRepository.findAll()
                .stream()
                .map(departement -> new DepartementReadRequest(departement.getNomDepartement())).
                collect(Collectors.toList());
    }

    @Override
    public Departement updateDepartement(
            DepartementCreateRequest createRequest,
            Long id)
    {

        var departement = departementRepository.findById(id)
                .orElseThrow(() ->new DepartementNotFoundException("Departement not found"));

        departement.setNomDepartement(createRequest.getNomDepartement());

        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(Long id) {
        var departement = departementRepository.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException("Departement not found"));

        departementRepository.delete(departement);
    }

    @Override
    public DepartementReadRequest getDepartement(Long id) {


        var departement = departementRepository.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException("Departement not found"));

        var readRequest = new DepartementReadRequest(departement.getNomDepartement());

        return readRequest;
    }
}
