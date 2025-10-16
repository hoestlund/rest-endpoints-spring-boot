package com.hostlund.snus.services;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface SnusService {

  static SnusDTO snusToDTO(Snus snus) {
    if (snus == null) {
      throw new IllegalArgumentException("snus cannot be null");
    }
    return new SnusDTO(snus.getVersion(), snus.getName(), snus.getDescription(),
        snus.getFlavour(), snus.getPrice(), snus.getManufacturer(),
        snus.getNicotineMilligramsPerGram());
  }

  static Snus DTOToSnus(SnusDTO snusDTO) {
    if (snusDTO == null) {
      throw new IllegalArgumentException("snusDTO cannot be null");
    }
    return Snus.builder()
        .id(UUID.randomUUID())
        .version(snusDTO.version())
        .name(snusDTO.name())
        .flavour(snusDTO.flavour())
        .manufacturer(snusDTO.manufacturer())
        .nicotineMilligramsPerGram(snusDTO.nicotineMilligramsPerGram())
        .description(snusDTO.description())
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .build();
  }

  void updateSnus(UUID id, Snus snus);

  Snus saveSnus(Snus snus);

  Snus getSnusById(UUID id);

  List<Snus> listSnus();

  void deleteSnusById(UUID id);
}
