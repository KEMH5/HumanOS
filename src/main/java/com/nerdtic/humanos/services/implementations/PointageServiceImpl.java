package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.Pointage;
import com.nerdtic.humanos.exception.PointageAlreadyExistsException;
import com.nerdtic.humanos.exception.PointageNotFoundException;
import com.nerdtic.humanos.repositories.PointageRepository;
import com.nerdtic.humanos.services.PointageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointageServiceImpl implements PointageService {

    private final PointageRepository pointageRepository;

    @Override
    public List<Pointage> getAllPointages() {
        return pointageRepository.findAll();
    }

    @Override
    public Pointage createPointage(Pointage pointage) {

        Optional<Pointage> existingPointage = pointageRepository.findById(pointage.getId());

        if(existingPointage.isPresent()){
            throw new PointageAlreadyExistsException("Pointage already exists");
        }
        return pointageRepository.save(pointage);
    }

    @Override
    public Pointage updatePointage(Pointage pointageDetails, int id) {

        Optional<Pointage> pointage = pointageRepository.findById(id);

        if(pointage.isPresent()) {
            Pointage updatedPointage = pointage.get();

            updatedPointage.setStatut(pointageDetails.getStatut());
            updatedPointage.setDatePointage(pointageDetails.getDatePointage());
            updatedPointage.setHeurePointage(pointageDetails.getHeurePointage());
            updatedPointage.setUser(pointageDetails.getUser());

            pointageRepository.save(updatedPointage);
        }

        throw new PointageNotFoundException("Pointage not found");
    }

    @Override
    public void deletePointage(int id) {

        Optional<Pointage> pointage = pointageRepository.findById(id);

        if(pointage.isPresent()) {
            pointageRepository.delete(pointage.get());
        }

        else {
            throw new PointageNotFoundException("Pointage not found");
        }
    }

    @Override
    public Pointage getPointageById(int id) {

        Optional<Pointage> pointage = pointageRepository.findById(id);
        if(pointage.isPresent()) {
            return pointage.get();
        }

        else {
            throw new PointageNotFoundException("Pointage not found");
        }
    }
}
