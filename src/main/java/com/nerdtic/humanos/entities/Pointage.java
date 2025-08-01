package com.nerdtic.humanos.entities;

import com.nerdtic.humanos.security.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pointage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime datePointage;

    @Enumerated
    @Column(name = "statutPointage")
    private StatutPointage statut;

    private LocalDateTime heurePointage;

}
