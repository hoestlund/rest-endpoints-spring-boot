package com.hostlund.snus.services;

import com.hostlund.snus.dto.AddressDTO;
import com.hostlund.snus.dto.CustomerDTO;
import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Customer;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomer(UUID id);

    List<CustomerDTO> getCustomers();

    CustomerDTO saveCustomer(CustomerDTO customer);

    void updateCustomer(UUID id, CustomerDTO customer);

    void deleteCustomer(UUID id);

    void patchCustomer(UUID id, CustomerDTO customer);
}
