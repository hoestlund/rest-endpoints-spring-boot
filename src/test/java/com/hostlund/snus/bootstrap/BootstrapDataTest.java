package com.hostlund.snus.bootstrap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.Is.is;


import com.hostlund.snus.repositories.CustomerRepository;
import com.hostlund.snus.repositories.SnusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class BootstrapDataTest {

    @Autowired
    SnusRepository snusRepository;

    @Autowired
    CustomerRepository customerRepository;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(snusRepository, customerRepository);
    }

    @Test
    void run() throws Exception {
        bootstrapData.run();

       assertThat(snusRepository.findAll().size()).isEqualTo(3);
       assertThat(customerRepository.findAll().size()).isEqualTo(2);
    }

}