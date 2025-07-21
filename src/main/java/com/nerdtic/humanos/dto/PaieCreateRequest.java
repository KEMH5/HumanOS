package com.nerdtic.humanos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaieCreateRequest {

    private LocalDate periodePaiementDebut;

    private LocalDate periodePaiementFin;

    private Float salaireBrut;

    private Float salaireNet;

    private int heureTravail;

    private Boolean statut;

    private Float tauxHoraire;

    private Float montantHeureSup;

    private Long idUser;
}
