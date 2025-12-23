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
class RestrictedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    void whenAuthenticated_thenCanAccessRestrictedEndpoint() throws Exception {
        mockMvc.perform(get("/api/restricted"))
                .andExpect(status().isOk())
                .andExpect(content().string("You have access..."));
    }

    @Test
    void whenNotAuthenticated_thenCannotAccessRestrictedEndpoint() throws Exception {
        mockMvc.perform(get("/api/restricted"))
                .andExpect(status().isUnauthorized());
    }
}