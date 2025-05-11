package com.hostlund.snus.services;

import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Customer;
import com.neovisionaries.i18n.CountryCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private final Map<UUID,Customer> customerMap;

  public CustomerServiceImpl() {
    this.customerMap = new HashMap<>();

    Customer customer_1 = Customer.builder()
        .id(UUID.randomUUID())
        .firstName("Laila")
        .lastName("Ross")
        .email("laila.ross@gmail.com")
        .address(Address.builder()
            .firstLine("Puttbusser Str")
            .houseNumber(8)
            .city("Berlin")
            .cc(CountryCode.DE)
            .build())
        .build();

    Customer customer_2 = Customer.builder()
        .id(UUID.randomUUID())
        .firstName("Jeremy")
        .lastName("Walton")
        .email("jwally@gmail.com")
        .address(Address.builder()
            .firstLine("Högsbogatan")
            .houseNumber(23)
            .city("Gothenburg")
            .cc(CountryCode.SE)
            .build())
        .build();

    customerMap.put(customer_1.getId(),customer_1);
    customerMap.put(customer_2.getId(),customer_2);
  }

  @Override
  public Customer getCustomer(UUID id) {
    return customerMap.get(id);
  }

  @Override
  public List<Customer> getCustomers() {
    return new ArrayList<>(customerMap.values());
  }
}
