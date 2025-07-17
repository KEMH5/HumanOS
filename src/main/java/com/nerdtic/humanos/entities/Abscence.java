package com.nerdtic.humanos.entities;

import com.nerdtic.humanos.security.entities.User;
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
public class Abscence {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String typeAbscence;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean statut;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "abscences"
    )
    private List<User> users;
}
