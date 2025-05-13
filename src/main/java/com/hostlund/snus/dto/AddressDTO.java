package com.hostlund.snus.dto;

import com.neovisionaries.i18n.CountryCode;

public record AddressDTO(Integer houseNumber, String firstLine, String secondLine, String city, String state, String postalCode, CountryCode country) {

}
