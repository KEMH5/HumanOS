package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Conge;
import com.nerdtic.humanos.exception.CongeAlreadyExistsException;
import com.nerdtic.humanos.exception.CongeNotFoundException;
import com.nerdtic.humanos.repositories.CongeRepository;
import com.nerdtic.humanos.services.CongeService;
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

        if(congeRepository.findByTypeConge(conge.getTypeConge()).isPresent()){
            throw new CongeAlreadyExistsException("Conge already exists");
        }
        return congeRepository.save(conge);
    }

    @Override
    public Conge updateConge(Conge congeDetails, int id) {

        Optional<Conge> conge = congeRepository.findById(id);

        if(conge.isPresent()){
            Conge updatedConge = conge.get();

            updatedConge.setTypeConge(congeDetails.getTypeConge());
            updatedConge.setDescription(congeDetails.getDescription());
            updatedConge.setStatus(congeDetails.getStatus());
            updatedConge.setEndDate(congeDetails.getEndDate());
            updatedConge.setStartDate(congeDetails.getStartDate());
            updatedConge.setEndDate(congeDetails.getEndDate());
            updatedConge.setUser(congeDetails.getUser());

            return congeRepository.save(updatedConge);
        }
        throw new CongeNotFoundException("Conge not found");
    }

    @Override
    public void deleteConge(int id) {

        Optional<Conge> conge = congeRepository.findById(id);

        if(conge.isPresent()){
            congeRepository.delete(conge.get());
        }

        else {
            throw new CongeNotFoundException("Conge not found");
        }
    }

    @Override
    public Conge getConge(int id) {

        Optional<Conge> conge = congeRepository.findById(id);

        if(conge.isPresent()){
            return conge.get();
        }

        else {
            throw new CongeNotFoundException("Conge not found");
        }
    }
}
