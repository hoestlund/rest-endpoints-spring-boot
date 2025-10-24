package com.hostlund.snus.services;

import com.hostlund.snus.dto.AddressDTO;
import com.hostlund.snus.dto.CustomerDTO;
import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Customer;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

    static CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        return new CustomerDTO(customer.getId(), customer.getVersion(), customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getAddress() == null ? null
                : new AddressDTO(
                    customer.getAddress().getHouseNumber(),
                    customer.getAddress().getFirstLine(), customer.getAddress().getSecondLine(),
                    customer.getAddress().getCity(), customer.getAddress().getState(),
                    customer.getAddress().getPostalCode(), customer.getAddress().getCountry()));
    }

    static Customer toEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            throw new IllegalArgumentException("CustomerDTO cannot be null");
        }

        return Customer.builder()
            .id(UUID.randomUUID()).firstName(customerDTO.firstName())
            .lastName(customerDTO.lastName())
            .email(customerDTO.email())
            .address(customerDTO.address() == null ? null : Address.builder()
                .houseNumber(customerDTO.address().houseNumber())
                .firstLine(customerDTO.address().firstLine())
                .secondLine(customerDTO.address().secondLine())
                .city(customerDTO.address().city())
                .state(customerDTO.address().state())
                .postalCode(customerDTO.address().postalCode())
                .country(customerDTO.address().country())
                .build())
            .build();
    }

    Customer getCustomer(UUID id);

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    void updateCustomer(UUID id, Customer customer);

    void deleteCustomer(UUID id);

    void patchCustomer(UUID id, Customer entity);
}
