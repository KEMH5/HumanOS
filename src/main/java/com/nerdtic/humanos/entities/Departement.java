package com.nerdtic.humanos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nomDepartement;


    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "formation_id"
    )
    private Formation formation;


}
