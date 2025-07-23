package com.nerdtic.humanos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AbscenceCreateRequest {

    private String typeAbscence;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean statut;

    private Long idUser;

}
