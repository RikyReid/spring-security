package com.goomba.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class RestrictedSecurityConfig {
    @Bean
    @Order(0)
    public SecurityFilterChain restrictedSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/restricted/**")
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity (not recommended for production)
                .httpBasic(Customizer.withDefaults()) // Disable HTTP Basic authentication
                .formLogin(form -> form.disable());  // Disable form login

        return http.build();
    }
}
