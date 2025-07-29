package com.nerdtic.humanos.security.dto;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private Long idRole;

    private Long idDepartement;

    private Long idAbscence;

    private Long idFormation;


}
