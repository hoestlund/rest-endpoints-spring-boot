package com.hostlund.snus.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;

import com.hostlund.snus.services.SnusService;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SnusController.class)
class SnusControllerTest {

    @Autowired
    MockMvc mockMVC;

    @MockitoBean
    SnusService snusService;

    @Test
    void getSnusById() throws Exception {
        mockMVC.perform(get("/api/v1/snus/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void getSnus() throws Exception {
        mockMVC.perform(get("/api/v1/snus").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
            //.andExpect(jsonPath("$[0].name", is("Apres N°7 Very Berry")))
            //.andExpect(jsonPath("$.length()", is(3)));
    }
}