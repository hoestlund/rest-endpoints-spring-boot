package com.hostlund.snus.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Manufacturer {

  private String name;
  private Address address;

}
