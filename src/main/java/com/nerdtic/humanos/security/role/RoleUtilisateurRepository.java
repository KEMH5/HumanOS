package com.nerdtic.humanos.security.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleUtilisateurRepository extends JpaRepository<RoleUtilisateur, Long> {
    Optional<RoleUtilisateur> findByTitle(String role);
}
