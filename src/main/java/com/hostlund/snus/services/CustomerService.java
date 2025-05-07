package com.hostlund.snus.services;

import com.hostlund.snus.model.Customer;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

  Customer getCustomer(UUID id);

  List<Customer> getCustomers();

}
