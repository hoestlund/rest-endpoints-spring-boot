package com.hostlund.snus.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.repositories.SnusRepository;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SnusControllerIT {

    @Autowired
    SnusController snusController;

    @Autowired
    SnusRepository snusRepository;

    @Test
    void testListAllSnus() {
        assertEquals(3, snusController.getSnus().size());
    }

    @Transactional
    @Test
    void testEmptyList() {
        snusRepository.deleteAll();
        assertEquals(0, snusController.getSnus().size());
    }

    @Test
    void testFindById() {
        Snus snus = snusRepository.findAll().getFirst();
        SnusDTO snusDTO = snusController.getSnusById(snus.getId());

        assertNotNull(snusDTO);
    }

    @Test
    void testFindByIdErrorHandling() {
        assertThrows(NotFoundException.class, () -> snusController.getSnusById(UUID.randomUUID()));
    }

}