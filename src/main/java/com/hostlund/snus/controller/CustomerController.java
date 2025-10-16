package com.hostlund.snus.controller;

import static com.hostlund.snus.services.CustomerService.toEntity;
import static com.hostlund.snus.services.SnusService.DTOToSnus;

import com.hostlund.snus.dto.CustomerDTO;
import com.hostlund.snus.model.Customer;
import com.hostlund.snus.services.CustomerService;
import com.hostlund.snus.services.SnusService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;
  private final SnusService snusService;

  @PostMapping
  public ResponseEntity<CustomerDTO> handlePost(@RequestBody CustomerDTO customer,
      UriComponentsBuilder uriBuilder) {
    Customer savedCustomer = customerService.saveCustomer(toEntity(customer));
    URI location = uriBuilder.path("api/v1/customer/{id}")
        .buildAndExpand(savedCustomer.getId())
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Customer getCustomerById(@PathVariable("id") UUID id) {
    return customerService.getCustomer(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @PutMapping({"/{id}"})
  public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") UUID id, @RequestBody CustomerDTO customer) {

    customerService.updateCustomer(id, customerService.saveCustomer(toEntity(customer)));
    return ResponseEntity.noContent().build();
  }

}
