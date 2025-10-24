package com.hostlund.snus.services;

import com.hostlund.snus.dto.AddressDTO;
import com.hostlund.snus.model.Address;
import java.util.UUID;

public interface AddressService {

  static AddressDTO toDTO(Address address) {
    if (address == null) {
      return null;
    }

    return new AddressDTO( address.getHouseNumber(), address.getFirstLine(), address.getSecondLine(),
        address.getCity(), address.getState(), address.getPostalCode(), address.getCountry());
  }

  static Address toEntity(AddressDTO addressDTO) {
    if (addressDTO == null) {
      return null;
    }
    return Address.builder().houseNumber(addressDTO.houseNumber()).firstLine(
        addressDTO.firstLine()).secondLine(addressDTO.secondLine()).city(addressDTO.city()).state(
        addressDTO.state()).postalCode(addressDTO.postalCode()).country(addressDTO.country()).build();
  }

}
