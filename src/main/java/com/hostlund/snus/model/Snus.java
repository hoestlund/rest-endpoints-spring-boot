package com.hostlund.snus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Snus {

  @Id
  private UUID id;
  @Version
  private Integer version;
  private String name;
  private String description;
  private Flavour flavour;
  private BigDecimal price;
  private Manufacturer manufacturer;
  private Integer nicotineMilligramsPerGram;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;

}
