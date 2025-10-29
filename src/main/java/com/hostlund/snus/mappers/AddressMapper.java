package com.hostlund.snus.mappers;

import com.hostlund.snus.dto.AddressDTO;
import com.hostlund.snus.model.Address;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {

    Address DTOToAddress(AddressDTO addressDTO);
    AddressDTO AddressToDTO(Address address);

}
