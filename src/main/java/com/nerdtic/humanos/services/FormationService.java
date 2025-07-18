package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Formation;

import java.util.List;


public interface FormationService {

    List<Formation> getAllFormations();

    Formation createFormation(Formation formation);

    Formation updateFormation(Formation formation, int id);

    void deleteFormation(int id);

    Formation getFormationById(int id);
}
