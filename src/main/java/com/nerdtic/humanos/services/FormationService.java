package com.nerdtic.humanos.services;

import com.nerdtic.humanos.dto.FormationCreateRequest;
import com.nerdtic.humanos.entities.Formation;

import java.util.List;


public interface FormationService {

    List<Formation> getAllFormations();

    Formation createFormation(FormationCreateRequest createRequest);

    Formation updateFormation(FormationCreateRequest createRequest, Long id);

    void deleteFormation(Long id);

    Formation getFormationById(Long id);
}
