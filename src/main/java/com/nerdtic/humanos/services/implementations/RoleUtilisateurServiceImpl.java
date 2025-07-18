package com.nerdtic.humanos.services.implementations;

import com.nerdtic.humanos.entities.RoleUtilisateur;
import com.nerdtic.humanos.repositories.RoleUtilisateurRepository;
import com.nerdtic.humanos.services.RoleUtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUtilisateurServiceImpl implements RoleUtilisateurService {
    private RoleUtilisateurRepository roleUtilisateurRepository;

    public RoleUtilisateurServiceImpl(
            RoleUtilisateurRepository roleUtilisateurRepository
    ) {
        this.roleUtilisateurRepository = roleUtilisateurRepository;
    }

    @Override
    public RoleUtilisateur createRoleUtilisateur(
            RoleUtilisateur roleUtilisateur
    ) {
        return roleUtilisateurRepository.save(roleUtilisateur);
    }

    @Override
    public RoleUtilisateur getRoleUtilisateur(
            Integer id
    ) {
        return roleUtilisateurRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<RoleUtilisateur> getAllRoleUtilisateurs() {
        return roleUtilisateurRepository.findAll();
    }

    @Override
    public void deleteRoleUtilisateur(Integer id) {
        roleUtilisateurRepository.deleteById(id);
    }
}
