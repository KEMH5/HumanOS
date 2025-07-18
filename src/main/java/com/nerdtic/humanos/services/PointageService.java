package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.Pointage;

import java.util.List;

public interface PointageService {

    List<Pointage> getAllPointages();

    Pointage createPointage(Pointage pointage);

    Pointage updatePointage(Pointage pointage, int id);

    void deletePointage(int id);

    Pointage getPointageById(int id);
}
