package com.nerdtic.humanos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContratCreateRequest {

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private String description;

    private Long idTypeContrat;

    private Long idPoste;

    private Long idUser;

}
