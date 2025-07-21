package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.FeuilleTempsCreateRequest;
import com.nerdtic.humanos.entities.FeuilleTemps;
import com.nerdtic.humanos.exception.FeuilleTempsNotFound;
import com.nerdtic.humanos.repositories.FeuilleTempsRepository;
import com.nerdtic.humanos.security.repositories.UserRepository;
import com.nerdtic.humanos.services.FeuilleTempsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeuilleTempsServiceImpl implements FeuilleTempsService {

    private final FeuilleTempsRepository feuilleTempsRepository;
    private final UserRepository userRepository;

    @Override
    public List<FeuilleTemps> getAllFeuilleDeTemps() {
        return feuilleTempsRepository.findAll();
    }

    @Override
    public FeuilleTemps createFeuilleDeTemps(FeuilleTempsCreateRequest createRequest) {

       var user = userRepository.findById(createRequest.getIdUser())
               .orElseThrow(() -> new RuntimeException("User not found"));

       var feuilleDeTemps = new FeuilleTemps();

       feuilleDeTemps.setDate(createRequest.getDate());
       feuilleDeTemps.setHeureDebutProgramme(createRequest.getHeureDebutProgramme());
       feuilleDeTemps.setHeureFinProgramme(createRequest.getHeureFinProgramme());
       user.setId(createRequest.getIdUser());

       return feuilleTempsRepository.save(feuilleDeTemps);
    }

    @Override
    public FeuilleTemps updateFeuilleDeTemps(FeuilleTempsCreateRequest createRequest, Long id) {

        var feuilleDeTemps = feuilleTempsRepository.findById(id)
                .orElseThrow(() -> new FeuilleTempsNotFound("Feuille Temps not found"));

        var user = userRepository.findById(createRequest.getIdUser())
                .orElseThrow(() -> new RuntimeException("User not found"));

        feuilleDeTemps.setDate(createRequest.getDate());
        feuilleDeTemps.setHeureDebutProgramme(createRequest.getHeureDebutProgramme());
        feuilleDeTemps.setHeureFinProgramme(createRequest.getHeureFinProgramme());
        user.setId(createRequest.getIdUser());

        return feuilleTempsRepository.save(feuilleDeTemps);
    }

    @Override
    public void deleteFeuilleDeTemps(Long id) {

        Optional<FeuilleTemps>  feuilleTemps = feuilleTempsRepository.findById(id);

        if(feuilleTemps.isPresent()) {
            feuilleTempsRepository.delete(feuilleTemps.get());
        }

        else {
            throw new FeuilleTempsNotFound("Feuille de Temps not found");
        }
    }

    @Override
    public FeuilleTemps getFeuilleDeTemps(Long id) {

        Optional<FeuilleTemps> feuilleTemps = feuilleTempsRepository.findById(id);

        if(feuilleTemps.isPresent()) {
            return feuilleTemps.get();
        }

        else {
            throw new FeuilleTempsNotFound("Feuille de temps not found");

        }

    }
}
