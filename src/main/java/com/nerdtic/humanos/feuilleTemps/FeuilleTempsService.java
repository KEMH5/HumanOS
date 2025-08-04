package com.nerdtic.humanos.feuilleTemps;

import java.util.List;

public interface FeuilleTempsService {

    List<FeuilleTemps> getAllFeuilleDeTemps();

    FeuilleTemps createFeuilleDeTemps(FeuilleTempsCreateRequest createRequest);

    FeuilleTemps updateFeuilleDeTemps(FeuilleTempsCreateRequest createRequest, Long id);

    void deleteFeuilleDeTemps(Long id);

    FeuilleTemps getFeuilleDeTemps(Long id);
}
