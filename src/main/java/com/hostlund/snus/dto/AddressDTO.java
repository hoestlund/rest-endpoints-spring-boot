package com.hostlund.snus.dto;

import com.neovisionaries.i18n.CountryCode;
import java.util.UUID;

public record AddressDTO(UUID id, Integer houseNumber, String firstLine, String secondLine, String city, String state, String postalCode, CountryCode country) {

}
