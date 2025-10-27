package com.hostlund.snus.services;

import com.hostlund.snus.dto.AddressDTO;
import com.hostlund.snus.dto.CustomerDTO;
import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Customer;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer getCustomer(UUID id);

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    void updateCustomer(UUID id, Customer customer);

    void deleteCustomer(UUID id);

    void patchCustomer(UUID id, Customer entity);
}
