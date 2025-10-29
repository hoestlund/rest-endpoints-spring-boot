package com.hostlund.snus.dto;

import com.hostlund.snus.model.Flavour;
import com.hostlund.snus.model.Manufacturer;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;


@Builder
public record SnusDTO(UUID id, Integer version, @NotNull String name, String description,
                      Flavour flavour,
                      BigDecimal price, Manufacturer manufacturer,
                      Integer nicotineMilligramsPerGram) {

}
