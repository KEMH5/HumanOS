package com.nerdtic.humanos.formation;

import java.util.List;


public interface FormationService {

    List<Formation> getAllFormations();

    Formation createFormation(FormationCreateRequest createRequest);

    Formation updateFormation(FormationCreateRequest createRequest, Long id);

    void deleteFormation(Long id);

    Formation getFormationById(Long id);
}
