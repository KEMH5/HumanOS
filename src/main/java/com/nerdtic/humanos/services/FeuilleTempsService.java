package com.nerdtic.humanos.services;

import com.nerdtic.humanos.dto.FeuilleTempsCreateRequest;
import com.nerdtic.humanos.entities.FeuilleTemps;

import java.util.List;

public interface FeuilleTempsService {

    List<FeuilleTemps> getAllFeuilleDeTemps();

    FeuilleTemps createFeuilleDeTemps(FeuilleTempsCreateRequest createRequest);

    FeuilleTemps updateFeuilleDeTemps(FeuilleTempsCreateRequest createRequest, Long id);

    void deleteFeuilleDeTemps(Long id);

    FeuilleTemps getFeuilleDeTemps(Long id);
}
