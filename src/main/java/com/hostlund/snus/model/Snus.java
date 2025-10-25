package com.hostlund.snus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
import org.hibernate.annotations.UuidGenerator;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Snus {

  @Id
  @UuidGenerator
  @GeneratedValue
  @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
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
