package com.hostlund.snus.controller;

import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SnusController {

  private final SnusService snusService;

  public Snus getSnusById(UUID id) {
    return snusService.getSnusById(id);
  }

  @RequestMapping("/api/v1/snus")
  public List<Snus> getSnus() {
    return snusService.listSnus();
  }

}
