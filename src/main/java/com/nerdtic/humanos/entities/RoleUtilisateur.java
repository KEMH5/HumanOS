package com.nerdtic.humanos.entities;

import com.nerdtic.humanos.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoleUtilisateur {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    private String title;

    private String description;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "userRoles"
    )
    private List<User> users;
}
