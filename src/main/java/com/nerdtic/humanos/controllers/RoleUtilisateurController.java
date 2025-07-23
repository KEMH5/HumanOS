package com.nerdtic.humanos.controllers;


import com.nerdtic.humanos.dto.RoleUtilisateurCreateRequest;
import com.nerdtic.humanos.entities.RoleUtilisateur;
import com.nerdtic.humanos.services.RoleUtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleUtilisateurController {
    private final RoleUtilisateurService roleUtilisateurService;

    public RoleUtilisateurController(
            RoleUtilisateurService roleUtilisateurService
    ) {
        this.roleUtilisateurService = roleUtilisateurService;
    }

    @PostMapping("/rolesUtilisateur")
    public RoleUtilisateur createRoleUtilisateur(
            @RequestBody
            RoleUtilisateurCreateRequest roleUtilisateur
    ){
        return roleUtilisateurService.createRoleUtilisateur(roleUtilisateur);
    }

    @GetMapping("/rolesUtilisateur")
    public List<RoleUtilisateur> getAllRoleUtilisateur(){
        return roleUtilisateurService.getAllRoleUtilisateurs();
    }

    @GetMapping("/rolesUtilisateur/{role-id}")
    public RoleUtilisateur getRoleUtilisateurById(
            @PathVariable("role-id")
            Long roleId
    ){
        return roleUtilisateurService.getRoleUtilisateur(roleId);
    }

    @DeleteMapping("/rolesUtilisateur/{role-id}")
    public void deleteRoleUtilisateurById(
            @PathVariable("role-id")
            Long roleId
    ){
        roleUtilisateurService.deleteRoleUtilisateur(roleId);
    }

}
