package com.nerdtic.humanos.entities;

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
public class Contrat {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private Integer id;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private String description;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
        name = "type_contrat_id"
    )
    private TypeContrat typeContrat;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "poste_id"
    )
    private Poste poste;

}