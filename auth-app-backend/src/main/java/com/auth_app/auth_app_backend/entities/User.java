package com.auth_app.auth_app_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String image;
    private boolean enabled = true;
    private Instant created_at = Instant.now();
    private Instant updated_at = Instant.now();

    private String gender;

    @Enumerated(EnumType.STRING)
    private Provider provider = Provider.LOCAL;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        if(created_at == null) created_at = now;
        updated_at = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = Instant.now();
    }

}
