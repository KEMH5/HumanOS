package com.nerdtic.humanos.services;

import com.nerdtic.humanos.entities.RoleUtilisateur;

import java.util.List;

public interface RoleUtilisateurService {
    RoleUtilisateur createRoleUtilisateur(RoleUtilisateur roleUtilisateur);
    RoleUtilisateur getRoleUtilisateur(Integer id);
    List<RoleUtilisateur> getAllRoleUtilisateurs();
    void deleteRoleUtilisateur(Integer id);
}
