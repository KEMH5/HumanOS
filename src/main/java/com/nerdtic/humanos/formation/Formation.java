package com.nerdtic.humanos.formation;

import com.nerdtic.humanos.security.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String titre;

    private String description;

    private String type;

    private String domaine;

    private Float duree;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "statutFormation"
    )
    private StatutFormation statut;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "formations"
    )
    private List<User> users;

}
