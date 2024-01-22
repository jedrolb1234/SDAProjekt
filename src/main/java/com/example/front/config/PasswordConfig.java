package com.example.front.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){ // implementacje interfejsu 'PasswordEncoder
        return new BCryptPasswordEncoder(10); // jedna z najpopularniejszych implementacji enkodera
    }
}
