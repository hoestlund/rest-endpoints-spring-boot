package com.hostlund.snus.mappers;

import com.hostlund.snus.dto.CustomerDTO;
import com.hostlund.snus.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO customerToDTO(Customer customer);

    Customer DTOToCustomer(CustomerDTO customerDTO);


}
