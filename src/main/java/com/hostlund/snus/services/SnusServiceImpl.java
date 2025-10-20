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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                    .country(CountryCode.DE)
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

    snusMap.put(pine.getId(), pine);
    snusMap.put(veryBerry.getId(), veryBerry);
    snusMap.put(appletini.getId(), appletini);
  }

  @Override
  public void updateSnus(UUID id, Snus snus) {
    if (!snusMap.containsKey(id)) {
      // Not sure if it is good practive to deal with HTTP codes in the service but IllegalArgument didn't seem that accurate and I don't want to have a custom exception (yet)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    snusMap.put(id, snus);
  }

  @Override
  public Snus saveSnus(Snus snus) {
    snusMap.put(snus.getId(), snus);
    return snus;
  }

  @Override
  public List<Snus> listSnus() {
    return new ArrayList<>((snusMap.values()));
  }

  @Override
  public void deleteSnusById(UUID id) {
    snusMap.remove(id);
  }

    @Override
    public void patchSnus(UUID id, Snus snus) {
    Snus existingSnus = snusMap.get(id);

        if(snus.getName() != null) {
          existingSnus.setName(snus.getName());
        }
        if(snus.getDescription() != null) {
          existingSnus.setDescription(snus.getDescription());
        }
        if(snus.getFlavour() != null) {
          existingSnus.setFlavour(snus.getFlavour());
        }
        if(snus.getPrice() != null) {
          existingSnus.setPrice(snus.getPrice());
        }
        if(snus.getManufacturer() != null) {
          existingSnus.setManufacturer(snus.getManufacturer());
        }
        if(snus.getNicotineMilligramsPerGram() != null) {
          existingSnus.setNicotineMilligramsPerGram(snus.getNicotineMilligramsPerGram());
        }
    }

    @Override
  public Snus getSnusById(UUID id) {
    return snusMap.get(id);
  }
}
