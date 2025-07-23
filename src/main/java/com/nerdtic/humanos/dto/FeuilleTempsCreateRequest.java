package com.nerdtic.humanos.dto;

import com.nerdtic.humanos.security.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
