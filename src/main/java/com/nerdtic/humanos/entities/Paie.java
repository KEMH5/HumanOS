package com.nerdtic.humanos.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paie {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private LocalDate periodePaiementDebut;

    private LocalDate periodePaiementFin;

    private Float salaireBrut;

    private Float salaireNet;

    private int heureTravail;

    private Boolean statut;

    private Float tauxHoraire;

    private Float montantHeureSup;
}
