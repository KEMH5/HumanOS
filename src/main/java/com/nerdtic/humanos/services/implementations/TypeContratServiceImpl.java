package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.TypeContrat;
import com.nerdtic.humanos.repositories.TypeContratRepository;
import com.nerdtic.humanos.services.TypeContratService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeContratServiceImpl implements TypeContratService {
    private final TypeContratRepository typeContratRepository;

    public TypeContratServiceImpl(TypeContratRepository typeContratRepository) {
        this.typeContratRepository = typeContratRepository;
    }

    @Override
    public TypeContrat save(
            TypeContrat typeContrat
    ) {
        return typeContratRepository.save(typeContrat);
    }

    @Override
    public TypeContrat getTypeContratById(
            Long id
    ) {
        return typeContratRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<TypeContrat> getAllTypeContrats() {
        return typeContratRepository.findAll();
    }

    @Override
    public void deleteTypeContratById(
           Long id
    ) {
        typeContratRepository.deleteById(id);
    }

    @Override
    public List<TypeContrat> getAllTypeContratByName(
            String name
    ) {
        return typeContratRepository.findAllByNameContaining(name);
    }
}
