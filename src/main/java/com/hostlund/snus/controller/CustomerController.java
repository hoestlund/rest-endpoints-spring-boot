package com.hostlund.snus.controller;

import com.hostlund.snus.dto.CustomerDTO;
import com.hostlund.snus.mappers.CustomerMapper;
import com.hostlund.snus.model.Customer;
import com.hostlund.snus.services.CustomerService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CustomerDTO> handlePost(@RequestBody CustomerDTO customer,
        UriComponentsBuilder uriBuilder) {
        CustomerDTO savedCustomer = customerService.saveCustomer(customer);
        URI location = uriBuilder.path("api/v1/customer/{id}")
            .buildAndExpand(savedCustomer.id())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CustomerDTO getCustomerById(@PathVariable("id") UUID id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerDTO> getCustomers() {
        return customerService.getCustomers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") UUID id,
        @RequestBody CustomerDTO customer) {

        customerService.updateCustomer(id,
            customerService.saveCustomer(customer));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") UUID id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable("id") UUID id,
        @RequestBody CustomerDTO customer) {
        customerService.patchCustomer(id, customer);
        return ResponseEntity.noContent().build();
    }

}
