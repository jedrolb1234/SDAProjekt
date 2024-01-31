package com.example.front.repository;

import com.example.front.Auth.ApplicationUser;
import com.example.front.Auth.ApplicationUserDao;
import com.example.front.security.UserRole;
import com.example.front.user.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("mysql")
public class MySqlApplicationUserDao implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public MySqlApplicationUserDao(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(this::mapEntityToModel).collect(Collectors.toList());
    }

    private ApplicationUser mapEntityToModel(UserEntity entity) {
        return new ApplicationUser(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getAuthorities().stream()
                        .flatMap(authority -> UserRole.valueOf(authority.getAuthority()).getGrantedAuthorities().stream())
                        .collect(Collectors.toSet()),
                entity.getEmail(),
                entity.getPhone(),
                entity.isAccountNonExpired(),
                entity.isAccountNonLocked(),
                entity.isCredentialsNonExpired(),
                entity.isEnabled()
        );
    }
}
