package com.hostlund.snus.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.hostlund.snus.repositories.SnusRepository;
import jakarta.transaction.Transactional;
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

}