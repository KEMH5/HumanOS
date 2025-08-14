package com.nerdtic.humanos.departement;

import java.util.List;

public interface DepartementService {

    List<Departement> getAllDepartements();

    Departement createDepartement(DepartementCreateRequest createRequest);

    Departement updateDepartement(DepartementCreateRequest createRequest, Long id);

    void deleteDepartement(Long id);

    DepartementReadRequest getDepartement(Long id);

}
