package com.nerdtic.humanos.typeContrat;

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
public class TypeContrat {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private Long id;

    private String name;

    private String description;

}