package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.FeuilleTemps;
import com.nerdtic.humanos.exception.FeuilleTempsNotFound;
import com.nerdtic.humanos.exception.FormationAlreadyExistsException;
import com.nerdtic.humanos.repositories.FeuilleTempsRepository;
import com.nerdtic.humanos.services.FeuilleTempsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FeuilleTempsServiceImpl implements FeuilleTempsService {

    private final FeuilleTempsRepository feuilleTempsRepository;

    @Override
    public List<FeuilleTemps> getFeuilleDeTemps() {
        return feuilleTempsRepository.findAll();
    }

    @Override
    public FeuilleTemps createFeuilleDeTemps(FeuilleTemps feuilleDeTemps) {

        Optional<FeuilleTemps> existingFeuilleTemps = feuilleTempsRepository.findById(feuilleDeTemps.getId());

        if(existingFeuilleTemps.isPresent()) {
            throw new FormationAlreadyExistsException("Feuille de Temps already exists");
        }
        return feuilleTempsRepository.save(feuilleDeTemps);
    }

    @Override
    public FeuilleTemps updateFeuilleDeTemps(FeuilleTemps feuilleDeTempsDetails, int id) {

        Optional<FeuilleTemps> feuilleTemps = feuilleTempsRepository.findById(id);

        if(feuilleTemps.isPresent()) {
            FeuilleTemps updatedFeuilleTemps =  feuilleTemps.get();

            updatedFeuilleTemps.setDate(feuilleDeTempsDetails.getDate());
            updatedFeuilleTemps.setHeureFinProgramme(feuilleDeTempsDetails.getHeureFinProgramme());
            updatedFeuilleTemps.setHeureDebutProgramme(feuilleDeTempsDetails.getHeureDebutProgramme());
            updatedFeuilleTemps.setUser(feuilleDeTempsDetails.getUser());

            return feuilleTempsRepository.save(updatedFeuilleTemps);
        }

        else {
            throw new FeuilleTempsNotFound("Feuille de Temps not found");
        }
    }

    @Override
    public void deleteFeuilleDeTemps(int id) {

        Optional<FeuilleTemps>  feuilleTemps = feuilleTempsRepository.findById(id);

        if(feuilleTemps.isPresent()) {
            feuilleTempsRepository.delete(feuilleTemps.get());
        }

        else {
            throw new FeuilleTempsNotFound("Feuille de Temps not found");
        }
    }

    @Override
    public FeuilleTemps getFeuilleDeTemps(int id) {

        Optional<FeuilleTemps> feuilleTemps = feuilleTempsRepository.findById(id);

        if(feuilleTemps.isPresent()) {
            return feuilleTemps.get();
        }

        throw new FeuilleTempsNotFound("Feuille de temps not found");
    }
}
