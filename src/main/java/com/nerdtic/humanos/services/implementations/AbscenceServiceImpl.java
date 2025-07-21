package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Abscence;
import com.nerdtic.humanos.repositories.AbscenceRepository;
import com.nerdtic.humanos.services.AbscenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbscenceServiceImpl implements AbscenceService {

    private final AbscenceRepository abscenceRepository;

    public AbscenceServiceImpl(AbscenceRepository abscenceRepository) {
        this.abscenceRepository = abscenceRepository;
    }

    @Override
    public Abscence createAbscence(
            Abscence abscence
    ) {
        return abscenceRepository.save(abscence);
    }

    @Override
    public Abscence findAbscence(
            Integer abscenceId
    ) {
        return abscenceRepository.findById(abscenceId)
                .orElse(null);
    }

    @Override
    public List<Abscence> findAllAbscences() {
        return abscenceRepository.findAll();
    }

    @Override
    public void deleteAbscence(
            Integer abscenceId
    ) {
        abscenceRepository.deleteById(abscenceId);
    }
}
