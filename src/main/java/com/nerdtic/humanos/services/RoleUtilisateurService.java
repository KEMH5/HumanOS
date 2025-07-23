package com.nerdtic.humanos.services;

import com.nerdtic.humanos.dto.RoleUtilisateurCreateRequest;
import com.nerdtic.humanos.entities.RoleUtilisateur;

import java.util.List;

public interface RoleUtilisateurService {
    RoleUtilisateur createRoleUtilisateur(RoleUtilisateurCreateRequest createRequest);
    RoleUtilisateur getRoleUtilisateur(Long id);
    List<RoleUtilisateur> getAllRoleUtilisateurs();
    void deleteRoleUtilisateur(Long id);
}
