package com.hostlund.snus.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Snus {

  private UUID id;
  private Integer version;
  private String name;
  private Flavour flavour;
  private BigDecimal price;
  private Manufacturer manufacturer;
  private Integer nicotineMilligramsPerGram;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;


}
