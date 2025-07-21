package com.nerdtic.humanos.entities;

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
public class Poste {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    private String title;

    private String description;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "poste"
    )
    private List<Contrat> contrats;

}
