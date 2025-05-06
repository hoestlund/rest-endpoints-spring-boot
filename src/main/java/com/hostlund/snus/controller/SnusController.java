package com.hostlund.snus.controller;

import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class SnusController {

  private final SnusService snusService;

  public Snus getSnusById(UUID id) {
    return snusService.getSnusById(id);
  }

}
