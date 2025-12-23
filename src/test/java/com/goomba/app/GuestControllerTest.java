package com.goomba.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "guest", roles = "GUEST")
    void whenAuthenticatedAsGuest_thenCanAccessGuestEndpoint() throws Exception {
        mockMvc.perform(get("/api/guest"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hey there guest..."));
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void whenAuthenticatedAsUser_thenCannotAccessGuestEndpoint() throws Exception {
        mockMvc.perform(get("/api/guest"))
                .andExpect(status().isForbidden());
    }

    @Test
    void whenNotAuthenticated_thenCannotAccessGuestEndpoint() throws Exception {
        mockMvc.perform(get("/api/guest"))
                .andExpect(status().isUnauthorized());
    }
}