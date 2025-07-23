package com.nerdtic.humanos.services;

import com.nerdtic.humanos.dto.DepartementCreateRequest;
import com.nerdtic.humanos.entities.Departement;

import java.util.List;

public interface DepartementService {

    List<Departement> getAllDepartements();

    Departement createDepartement(DepartementCreateRequest createRequest);

    Departement updateDepartement(DepartementCreateRequest createRequest, Long id);

    void deleteDepartement(Long id);

    Departement getDepartement(Long id);

}
