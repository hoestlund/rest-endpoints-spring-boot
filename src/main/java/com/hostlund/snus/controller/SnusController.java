package com.hostlund.snus.controller;

import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/snus")
public class SnusController {

  private final SnusService snusService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Snus getSnusById(@PathVariable("id") UUID id) {
    return snusService.getSnusById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Snus> getSnus() {
    System.out.println("!!!!!!!!!!!! Printing flavour");
    System.out.println(getSnusById(UUID.fromString("0c0b2f51-6c08-457a-b4b7-c2ceafb41159")));



    return snusService.listSnus();
  }

}
