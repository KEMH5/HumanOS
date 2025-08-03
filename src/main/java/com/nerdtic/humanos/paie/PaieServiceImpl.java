package com.nerdtic.humanos.paie;

import com.nerdtic.humanos.security.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaieServiceImpl implements PaieService {
    private final UserRepository userRepository;
    private PaieRepository paieRepository;

    public PaieServiceImpl(PaieRepository paieRepository, UserRepository userRepository) {
        this.paieRepository = paieRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Paie createPaie(
            PaieCreateRequest createRequest
    ) {
        var user = userRepository.findById(
                createRequest.getIdUser()
        ).orElseThrow(() -> new RuntimeException("User Not Found"));

        var paie = new Paie();

        paie.setHeureTravail(createRequest.getHeureTravail());
        paie.setSalaireBrut(createRequest.getSalaireBrut());
        paie.setSalaireNet(createRequest.getSalaireNet());
        paie.setMontantHeureSup(createRequest.getMontantHeureSup());
        paie.setStatut(createRequest.getStatut());
        paie.setTauxHoraire(createRequest.getTauxHoraire());
        paie.setPeriodePaiementDebut(createRequest.getPeriodePaiementDebut());
        paie.setPeriodePaiementFin(createRequest.getPeriodePaiementFin());
        paie.setUser(user);

        return paieRepository.save(paie);
    }

    @Override
    public Paie getPaie(
            Long id
    ) {
        return paieRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Paie> getPaies() {
        return paieRepository.findAll();
    }

    @Override
    public void deletePaie(
            Long id
    ) {
        paieRepository.deleteById(id);
    }
}
