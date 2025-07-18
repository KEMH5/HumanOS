package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Departement;

import java.util.List;

public interface DepartementService {

    Departement createDepartement(Departement departement);

    List<Departement> getAllDepartements();

    Departement updateDepartement(Departement departement, int id);

    Departement getDepartementById(int id);

    void deleteDepartement(int id);


}
