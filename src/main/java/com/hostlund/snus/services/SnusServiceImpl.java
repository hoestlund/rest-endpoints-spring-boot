package com.hostlund.snus.services;

import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Flavour;
import com.hostlund.snus.model.Manufacturer;
import com.hostlund.snus.model.Snus;
import com.neovisionaries.i18n.CountryCode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SnusServiceImpl implements SnusService {

  private Map<UUID, Snus> snusMap;

  public SnusServiceImpl() {
    this.snusMap = new HashMap<>();

    Snus pine = Snus.builder().id(UUID.randomUUID()).name("Pine")
        .description("Wood series. Pine needles, nordic cedar, delicate spices and mint")
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .flavour(new Flavour("Pine flavour"))
        .manufacturer(
            Manufacturer.builder()
                .name("NOTO")
                .address(Address.builder()
                    .firstLine("Bug Street 123")
                    .city("Berlin")
                    .cc(CountryCode.DE)
                    .build())
                .build())
        .build();

    Snus veryBerry = Snus.builder().id(UUID.randomUUID()).name("Apres N°7 Very Berry")
        .description("Long release wild berry and raspberry")
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now()).build();

    Snus appletini = Snus.builder().id(UUID.randomUUID()).name("Apres N°6 Appletini")
        .description("Refreshing green apple")
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .build();

    snusMap.put(pine.getId(),pine);
    snusMap.put(veryBerry.getId(),veryBerry);
    snusMap.put(appletini.getId(),appletini);
  }

  @Override
  public List<Snus> listSnus() {
    return new ArrayList<>((snusMap.values()));
  }

  @Override
  public Snus getSnusById(UUID id) {
    return snusMap.get(id);
  }
}
