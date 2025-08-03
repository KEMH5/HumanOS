package com.nerdtic.humanos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FeuilleTempsCreateRequest {

    private LocalDate heureDebutProgramme;

    private LocalDate heureFinProgramme;

    private LocalDate date;

    private Long idUser;
}
