package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Departement;
import com.nerdtic.humanos.exception.DepartementAlreadyExistsException;
import com.nerdtic.humanos.exception.DepartementNotFoundException;
import com.nerdtic.humanos.repositories.DepartementRepository;
import com.nerdtic.humanos.services.DepartementService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartementServiceImpl implements DepartementService {

    private final DepartementRepository departementRepository;

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement createDepartement(Departement departement) {

        if(departementRepository.findByNomDepartement(departement.getNomDepartement()).isPresent()) {
            throw new DepartementAlreadyExistsException(departement.getNomDepartement() + " already exists");
        }
        return departementRepository.save(departement);
    }

    @Override
    public Departement updateDepartement(Departement departementDetails, int id) {
        Optional<Departement> departement = departementRepository.findById(id);

        if(departement.isPresent()){
            Departement departementToUpdate = departement.get();
            departementToUpdate.setNomDepartement(departementDetails.getNomDepartement());
            departementToUpdate.setFormations(departementDetails.getFormations());

            return departementRepository.save(departementToUpdate);
        }

        else {
            throw new DepartementNotFoundException(departementDetails.getNomDepartement() +"Departement not found");

        }

    }

    @Override
    public Departement getDepartementById(int id) {
        Optional<Departement> departement = departementRepository.findById(id);

        if(departement.isPresent()){
            return departement.get();
        } else {
            throw new DepartementNotFoundException("Departement not found");
        }

    }

    @Override
    public void deleteDepartement(int id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new DepartementNotFoundException("Département not found"));

        try {
            departementRepository.delete(departement);
        } catch (Exception e) {
            throw new RuntimeException("Impossible de supprimer : le département est utilisé par d'autres entités", e);
        }
    }

}
