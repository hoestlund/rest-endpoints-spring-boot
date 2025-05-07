package com.hostlund.snus.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {

  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private Address address;

}
