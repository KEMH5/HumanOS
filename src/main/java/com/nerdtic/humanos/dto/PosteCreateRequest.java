package com.nerdtic.humanos.dto;

import lombok.Data;

@Data
public class PosteCreateRequest {

    private String title;

    private String description;

    private Long idContrat;
}
