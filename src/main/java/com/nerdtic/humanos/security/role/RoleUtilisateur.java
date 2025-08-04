package com.nerdtic.humanos.security.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nerdtic.humanos.security.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class RoleUtilisateur {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column(unique = true)
    private String title;

    private String description;

    @CreatedDate
    @Column(updatable=false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    @ManyToMany(
            mappedBy = "userRoles"
    )
    @JsonIgnore
    private List<User> users;
}
