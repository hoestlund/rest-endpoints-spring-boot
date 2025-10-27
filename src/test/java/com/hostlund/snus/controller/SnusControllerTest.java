package com.hostlund.snus.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;

import com.hostlund.snus.mappers.SnusMapper;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import java.util.List;
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

    @MockitoBean
    SnusMapper snusMapper;

    @Test
    void getSnusById() throws Exception {
        mockMVC.perform(get("/api/v1/snus/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }

    @Test
    void getSnus() throws Exception {
        // Stub for the list
        List<Snus> testSnusList = List.of(
            Snus.builder().id(UUID.randomUUID()).name("Pine").build(),
            Snus.builder().id(UUID.randomUUID()).name("Apres N°7 Very Berry").build(),
            Snus.builder().id(UUID.randomUUID()).name("Apres N°6 Appletini").build()
        );
        when(snusService.listSnus()).thenReturn(testSnusList);

        mockMVC.perform(get("/api/v1/snus").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.length()", is(3)));
    }
}