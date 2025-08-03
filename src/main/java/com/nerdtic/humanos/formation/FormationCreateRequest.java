package com.nerdtic.humanos.formation;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FormationCreateRequest {

    private String titre;

    private String description;

    private String type;

    private String domaine;

    private Float duree;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Long idUser;

    private StatutFormation statut;

}
