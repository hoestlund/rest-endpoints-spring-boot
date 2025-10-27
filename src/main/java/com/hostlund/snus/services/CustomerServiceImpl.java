package com.hostlund.snus.services;

import com.hostlund.snus.controller.NotFoundException;
import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Customer;
import com.hostlund.snus.repositories.CustomerRepository;
import com.neovisionaries.i18n.CountryCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

  @Override
  public Customer getCustomer(UUID id) {
    return customerRepository.findCustomerById(id);
  }

  @Override
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

    @Override
    public void updateCustomer(UUID id, Customer customer) {
      if(!customerRepository.existsById(id)){
          throw new NotFoundException();
      }
      customer.setId(id);
      customerRepository.save(customer);
    }

  @Override
  public void deleteCustomer(UUID id) {
      customerRepository.deleteById(id);
  }

    @Override
    public void patchCustomer(UUID id, Customer customer) {
        Customer existingCustomer = customerRepository.findCustomerById(id);

        if(customer.getFirstName() != null) {
          existingCustomer.setFirstName(customer.getFirstName());
        }
        if(customer.getLastName() != null) {
          existingCustomer.setLastName(customer.getLastName());
        }
        if(customer.getEmail() != null) {
          existingCustomer.setEmail(customer.getEmail());
        }
        if(customer.getAddress() != null) {
          existingCustomer.setAddress(customer.getAddress());
        }
        this.saveCustomer(existingCustomer);
    }


}
