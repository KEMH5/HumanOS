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
public class TypeContrat {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private Integer id;

    private String description;

}