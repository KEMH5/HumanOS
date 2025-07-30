package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.dto.AbscenceCreateRequest;
import com.nerdtic.humanos.entities.Abscence;
import com.nerdtic.humanos.repositories.AbscenceRepository;
import com.nerdtic.humanos.security.repositories.UserRepository;
import com.nerdtic.humanos.services.AbscenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbscenceServiceImpl implements AbscenceService {

    private final AbscenceRepository abscenceRepository;
    private final UserRepository userRepository;

    public AbscenceServiceImpl(AbscenceRepository abscenceRepository, UserRepository userRepository) {
        this.abscenceRepository = abscenceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Abscence createAbscence(
            AbscenceCreateRequest createRequest
    ) {
        var user = userRepository.findById(
                createRequest.getIdUser()
        ).orElseThrow(() -> new RuntimeException("User introuvable"));

        var abscence = new Abscence();

        abscence.setTypeAbscence(createRequest.getTypeAbscence());
        abscence.setStartDate(createRequest.getStartDate());
        abscence.setEndDate(createRequest.getEndDate());
        abscence.setStatut(createRequest.getStatut());
        abscence.setUser(user);

        return abscenceRepository.save(abscence);

    }

    @Override
    public List<Abscence> findAllAbscences() {
        return abscenceRepository.findAll();
    }

    @Override
    public void deleteAbscence(
            Long abscenceId
    ) {
        abscenceRepository.deleteById(abscenceId);
    }

}
