package com.nerdtic.humanos.security.user;

import com.nerdtic.humanos.absence.AbscenceRepository;
import com.nerdtic.humanos.departement.DepartementRepository;
import com.nerdtic.humanos.formation.FormationRepository;
import com.nerdtic.humanos.security.role.RoleUtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DepartementRepository departementRepository;
    private final AbscenceRepository abscenceRepository;
    private final RoleUtilisateurRepository roleUtilisateurRepository;
    private final FormationRepository formationRepository;



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





        var user = new User();

        user.setFirstName(createRequest.getFirstName());
        user.setLastName(createRequest.getLastName());
        user.setEmail(createRequest.getEmail());
        user.setPassword(createRequest.getPassword());
        user.setDepartement(departement);
        user.getUserRoles().add(role);
        if (createRequest.getIdFormation() != null){
            var formation = formationRepository.findById(
                            createRequest.getIdFormation())
                    .orElseThrow(() -> new RuntimeException("Formation not found"));
            user.getFormations().add(formation);
        }

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
