package com.nerdtic.humanos.typeContrat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeContratServiceImpl implements TypeContratService {
    private final TypeContratRepository typeContratRepository;

    public TypeContratServiceImpl(TypeContratRepository typeContratRepository) {
        this.typeContratRepository = typeContratRepository;
    }

    @Override
    public TypeContrat save(
            TypeContratCreateRequest createRequest
    ) {
        var typeContrat = new TypeContrat();
        typeContrat.setDescription(createRequest.getDescription());
        typeContrat.setName(createRequest.getName());
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
