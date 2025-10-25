package com.hostlund.snus.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hostlund.snus.model.Snus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class SnusRepositoryTest {

    @Autowired
    SnusRepository snusRepository;

    @Test
    void testSaveSnus() {
        Snus savedSnus = snusRepository.save(
            com.hostlund.snus.model.Snus.builder().name("Test Snus").build());
        assertNotNull(savedSnus);
        assertNotNull(savedSnus.getId());

    }

}