package com.hostlund.snus.services;

import com.hostlund.snus.controller.NotFoundException;
import com.hostlund.snus.dto.CustomerDTO;
import com.hostlund.snus.mappers.AddressMapper;
import com.hostlund.snus.mappers.CustomerMapper;
import com.hostlund.snus.model.Customer;
import com.hostlund.snus.repositories.CustomerRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressMapper addressMapper;

    @Override
    public CustomerDTO getCustomer(UUID id) {
        return customerMapper.customerToDTO(customerRepository.findCustomerById(id));
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::customerToDTO).toList();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        customerRepository.save(customerMapper.DTOToCustomer(customer));
        return customer;
    }

    @Override
    public void updateCustomer(UUID id, CustomerDTO customer) {
        if (!customerRepository.existsById(id)) {
            throw new NotFoundException();
        }
        customerRepository.save(customerMapper.DTOToCustomer(customer));
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void patchCustomer(UUID id, CustomerDTO customer) {
        Customer existingCustomer = customerRepository.findCustomerById(id);

        if (customer.firstName() != null) {
            existingCustomer.setFirstName(customer.firstName());
        }
        if (customer.lastName() != null) {
            existingCustomer.setLastName(customer.lastName());
        }
        if (customer.email() != null) {
            existingCustomer.setEmail(customer.email());
        }
        if (customer.address() != null) {
            existingCustomer.setAddress(addressMapper.DTOToAddress(customer.address()));
        }
        customerRepository.save(existingCustomer);
    }
}
