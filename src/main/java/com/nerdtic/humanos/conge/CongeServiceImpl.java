package com.nerdtic.humanos.conge;

import com.nerdtic.humanos.exception.CongeAlreadyExistsException;
import com.nerdtic.humanos.exception.CongeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CongeServiceImpl implements CongeService {

    private final CongeRepository congeRepository;

    @Override
    public List<Conge> getAllConge() {
        return  congeRepository.findAll();
    }

    @Override
    public Conge createConge(Conge conge) {

        var congeExcisting = congeRepository.findById(conge.getId());

        if(congeExcisting.isPresent()) {
            throw new CongeAlreadyExistsException("Conge already exits");
        }

        else {
            return congeRepository.save(conge);
        }
    }

    @Override
    public Conge updateConge(Conge congeDetails, Long id) {
        var conge = congeRepository.findById(id)
                .orElseThrow(() -> new CongeNotFoundException("Conge not found"));

        conge.setTypeConge(congeDetails.getTypeConge());
        conge.setDescription(congeDetails.getDescription());
        conge.setStartDate(congeDetails.getStartDate());
        conge.setEndDate(congeDetails.getEndDate());
        conge.setStatus(congeDetails.getStatus());

        return congeRepository.save(conge);
    }

    @Override
    public void deleteConge(Long id) {

        Optional<Conge> conge = congeRepository.findById(id);

        if(conge.isPresent()){
            congeRepository.delete(conge.get());
        }

        else {
            throw new CongeNotFoundException("Conge not found");
        }
    }

    @Override
    public Conge getConge(Long id) {

        Optional<Conge> conge = congeRepository.findById(id);

        if(conge.isPresent()){
            return conge.get();
        }

        else {
            throw new CongeNotFoundException("Conge not found");
        }
    }
}
