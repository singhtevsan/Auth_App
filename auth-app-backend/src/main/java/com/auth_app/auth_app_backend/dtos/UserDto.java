package com.auth_app.auth_app_backend.dtos;

import com.auth_app.auth_app_backend.entities.Provider;
import com.auth_app.auth_app_backend.entities.Role;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private int id;
    private String username;
    private String email;
    private String password;

    private String image;
    private boolean enabled = true;
    private Instant created_at = Instant.now();
    private Instant updated_at = Instant.now();

    private String gender;
    private Provider provider = Provider.LOCAL;
    private Set<RoleDto> roles = new HashSet<>();
}
