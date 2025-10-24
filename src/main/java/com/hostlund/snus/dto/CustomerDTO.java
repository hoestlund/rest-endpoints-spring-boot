package com.hostlund.snus.dto;

import java.util.UUID;

public record CustomerDTO(UUID id, Integer version, String firstName, String lastName, String email,
                          AddressDTO address) {

}
