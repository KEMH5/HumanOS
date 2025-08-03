package com.nerdtic.humanos.security.role;

import java.util.List;

public interface RoleUtilisateurService {
    RoleUtilisateur createRoleUtilisateur(RoleUtilisateurCreateRequest createRequest);
    RoleUtilisateur getRoleUtilisateur(Long id);
    List<RoleUtilisateur> getAllRoleUtilisateurs();
    void deleteRoleUtilisateur(Long id);
}
