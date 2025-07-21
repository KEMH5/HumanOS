package com.nerdtic.humanos.security.entities;


import com.nerdtic.humanos.entities.Abscence;
import com.nerdtic.humanos.entities.Departement;
import com.nerdtic.humanos.entities.RoleUtilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(
        name = "app_user"
)
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(
            unique=true
    )
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    @Column(
            unique=true
    )
    private String email;

    @ManyToMany
    @JoinTable(
            name = "user_roleUtilsateur",
            joinColumns = @JoinColumn(
                    name = "user_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "roleUtilisateur_id"
            )
    )
    private List<RoleUtilisateur> userRoles;

    @ManyToMany
    @JoinTable(
            name = "user_abscence",
            joinColumns = @JoinColumn(
                    name = "user_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "abscence_id"
            )
    )
    private List<Abscence> absences;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "departement_id"
    )
    private Departement departement;

}
