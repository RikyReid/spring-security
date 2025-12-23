package com.goomba.app;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsManager {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails guest = User
                .withUsername("guest")
                .password("{noop}password")  // {noop} means no password encoding (for testing only)
                .roles("GUEST")
                .build();

        UserDetails user = User
                .withUsername("user")
                .password("{noop}password")  // {noop} means no password encoding (for testing only)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user, guest);
    }
}
