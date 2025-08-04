package com.nerdtic.humanos.security.role;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rolesUtilisateur")
public class RoleUtilisateurController {
    private final RoleUtilisateurService roleUtilisateurService;

    public RoleUtilisateurController(
            RoleUtilisateurService roleUtilisateurService
    ) {
        this.roleUtilisateurService = roleUtilisateurService;
    }

    @PostMapping
    public RoleUtilisateur createRoleUtilisateur(
            @RequestBody
            RoleUtilisateurCreateRequest roleUtilisateur
    ){
        return roleUtilisateurService.createRoleUtilisateur(roleUtilisateur);
    }

    @GetMapping
    public List<RoleUtilisateur> getAllRoleUtilisateur(){
        return roleUtilisateurService.getAllRoleUtilisateurs();
    }

    @GetMapping("/{role-id}")
    public RoleUtilisateur getRoleUtilisateurById(
            @PathVariable("role-id")
            Long roleId
    ){
        return roleUtilisateurService.getRoleUtilisateur(roleId);
    }

    @DeleteMapping("/{role-id}")
    public void deleteRoleUtilisateurById(
            @PathVariable("role-id")
            Long roleId
    ){
        roleUtilisateurService.deleteRoleUtilisateur(roleId);
    }

}
