package com.nerdtic.humanos.services;

import com.nerdtic.humanos.dto.DepartementCreateRequest;
import com.nerdtic.humanos.entities.Departement;

public interface DepartementService {

    Departement createDepartement(DepartementCreateRequest createRequest);

}
