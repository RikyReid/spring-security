package com.goomba.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class PublicSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // Allow all requests without authentication
            )
            .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity (not recommended for production)
            .httpBasic(httpBasic -> httpBasic.disable())  // Disable HTTP Basic authentication
            .formLogin(form -> form.disable());  // Disable form login

        return http.build();
    }
}
