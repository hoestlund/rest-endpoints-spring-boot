package com.hostlund.snus.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.hostlund.snus.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomer() {
        Customer savedCustomer = customerRepository.save(Customer.builder().firstName("test").build());
        assertNotNull(savedCustomer);
        assertNotNull(savedCustomer.getId());
    }



}