package com.hostlund.snus.dto;

import com.hostlund.snus.model.Flavour;
import com.hostlund.snus.model.Manufacturer;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record SnusDTO(Integer version, @NotNull String name, String description, Flavour flavour,
                      BigDecimal price, Manufacturer manufacturer,
                      Integer nicotineMilligramsPerGram) {

}
