package com.nerdtic.humanos.dto;

import lombok.Data;

@Data
public class RoleUtilisateurCreateRequest {
    private String title;

    private String description;

    private Long idUser;
}
