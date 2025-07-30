package com.nerdtic.humanos.security.services.Impl;

import com.nerdtic.humanos.repositories.AbscenceRepository;
import com.nerdtic.humanos.repositories.DepartementRepository;
import com.nerdtic.humanos.repositories.FormationRepository;
import com.nerdtic.humanos.repositories.RoleUtilisateurRepository;
import com.nerdtic.humanos.security.dto.UserCreateRequest;
import com.nerdtic.humanos.security.entities.User;
import com.nerdtic.humanos.security.repositories.UserRepository;
import com.nerdtic.humanos.security.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DepartementRepository departementRepository;
    private final AbscenceRepository abscenceRepository;
    private final RoleUtilisateurRepository roleUtilisateurRepository;
    private final FormationRepository formationRepository;

    public UserServiceImpl(
            UserRepository userRepository,
            DepartementRepository departementRepository, AbscenceRepository abscenceRepository, RoleUtilisateurRepository roleUtilisateurRepository, FormationRepository formationRepository)
    {
        this.userRepository = userRepository;
        this.departementRepository = departementRepository;
        this.abscenceRepository = abscenceRepository;
        this.roleUtilisateurRepository = roleUtilisateurRepository;
        this.formationRepository = formationRepository;
    }


    @Override
    public User createUser(UserCreateRequest createRequest) {

        var departement = departementRepository.findById(
                createRequest.getIdDepartement()
        ).orElseThrow(() -> new RuntimeException("Departement not found"));

        var absence = abscenceRepository.findById(
                createRequest.getIdAbscence()
        ).orElseThrow(() -> new RuntimeException("Abscence not found"));

        var role = roleUtilisateurRepository.findById(
                createRequest.getIdRole()
        ).orElseThrow(() -> new RuntimeException("Role not found"));

        var formation = formationRepository.findById(
                createRequest.getIdFormation())
                .orElseThrow(() -> new RuntimeException("Formation not found"));


        var user = new User();

        user.setFirstName(createRequest.getFirstName());
        user.setLastName(createRequest.getLastName());
        user.setEmail(createRequest.getEmail());
        user.setUsername(createRequest.getUsername());
        user.setPassword(createRequest.getPassword());
        user.setDepartement(departement);
        user.getUserRoles().add(role);
        user.getFormations().add(formation);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUserByFirstName(String name) {
        return userRepository.findAllByFirstNameContaining(name);
    }
}
