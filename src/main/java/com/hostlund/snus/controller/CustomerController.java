package com.hostlund.snus.controller;

import com.hostlund.snus.model.Customer;
import com.hostlund.snus.services.CustomerService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Customer getCustomerById(@PathVariable("id") UUID id) {
    return customerService.getCustomer(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

}
