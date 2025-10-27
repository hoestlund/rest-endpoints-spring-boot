package com.hostlund.snus.repositories;

import com.hostlund.snus.model.Customer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findCustomerById(UUID id);
}
