package com.example.front.security;

public enum UserPermission {
    CLIENT_GUEST("user:client"),
    CLIENT_REGISTER("user:register"),
    ADMINISTRATOR("user:admin");


    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
