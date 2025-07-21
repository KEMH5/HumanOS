package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Pointage;

import java.util.List;

public interface PointageService {

    List<Pointage> getAllPointages();

    Pointage createPointage(Pointage pointage);

    Pointage updatePointage(Pointage pointage, Long id);

    void deletePointage(Long id);

    Pointage getPointageById(Long id);
}
