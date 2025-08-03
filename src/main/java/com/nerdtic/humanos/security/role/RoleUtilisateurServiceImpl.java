package com.nerdtic.humanos.security.role;

import com.nerdtic.humanos.security.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUtilisateurServiceImpl implements RoleUtilisateurService {
    private final UserRepository userRepository;
    private RoleUtilisateurRepository roleUtilisateurRepository;

    public RoleUtilisateurServiceImpl(
            RoleUtilisateurRepository roleUtilisateurRepository,
            UserRepository userRepository) {
        this.roleUtilisateurRepository = roleUtilisateurRepository;
        this.userRepository = userRepository;
    }

    @Override
    public RoleUtilisateur createRoleUtilisateur(
            RoleUtilisateurCreateRequest createRequest
    ) {
        var user = userRepository.findById(
                createRequest.getIdUser()
        ).orElseThrow(() -> new RuntimeException("User inttrouvable"));

        var roleUser = new RoleUtilisateur();
        roleUser.setTitle(createRequest.getTitle());
        roleUser.setDescription(createRequest.getDescription());
        roleUser.getUsers().add(user);

        return roleUtilisateurRepository.save(roleUser);

    }

    @Override
    public RoleUtilisateur getRoleUtilisateur(
            Long id
    ) {
        return roleUtilisateurRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<RoleUtilisateur> getAllRoleUtilisateurs() {
        return roleUtilisateurRepository.findAll();
    }

    @Override
    public void deleteRoleUtilisateur(Long id) {
        roleUtilisateurRepository.deleteById(id);
    }
}
