package com.nerdtic.humanos.dto;

import com.nerdtic.humanos.entities.Departement;
import com.nerdtic.humanos.entities.StatutFormation;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FormationCreateRequest {

    private String titre;

    private String description;

    private String type;

    private String domaine;

    private Float duree;

    private Float cout;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Long idUser;

    private StatutFormation statut;

}
