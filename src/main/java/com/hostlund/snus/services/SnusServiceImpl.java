package com.hostlund.snus.services;

import com.hostlund.snus.model.Snus;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class SnusServiceImpl implements SnusService {

  @Override
  public Snus getSnusById(UUID id) {
    return Snus.builder()
        .id(id)
        .name("Pine")
        .description("Wood series. Pine needles, nordic cedar, delicate spices and mint")
        .createdDate(LocalDateTime.now())
        //.flavour(new Flavour("Pine"))
        .build();
  }
}
