package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.FeuilleTemps;

import java.util.List;

public interface FeuilleTempsService {

    List<FeuilleTemps> getFeuilleDeTemps();

    FeuilleTemps createFeuilleDeTemps(FeuilleTemps feuilleDeTemps);

    FeuilleTemps updateFeuilleDeTemps(FeuilleTemps feuilleDeTemps, int id);

    void deleteFeuilleDeTemps(int id);

    FeuilleTemps getFeuilleDeTemps(int id);
}
