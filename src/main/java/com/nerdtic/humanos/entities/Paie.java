package com.nerdtic.humanos.entities;


import com.nerdtic.humanos.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paie {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private LocalDate periodePaiementDebut;

    private LocalDate periodePaiementFin;

    private Float salaireBrut;

    private Float salaireNet;

    private int heureTravail;

    private Boolean statut;

    private Float tauxHoraire;

    private Float montantHeureSup;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "user_id"
    )
    private User user;
}
