package com.example.demo.security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    SUPER_ADMIN("ROLE_SUPER_ADMIN"),ADMIN("ROLE_ADMIN");

    private final String roleName;
}
