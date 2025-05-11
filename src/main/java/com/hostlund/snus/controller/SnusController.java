package com.hostlund.snus.controller;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Flavour;
import com.hostlund.snus.model.Manufacturer;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/snus")
public class SnusController {

  private final SnusService snusService;

  @PostMapping
  public ResponseEntity handlePost(@RequestBody SnusDTO snus) {
    Snus savedSnus = snusService.saveNewSnus(snus);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Snus getSnusById(@PathVariable("id") UUID id) {
    return snusService.getSnusById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Snus> getSnus() {
    return snusService.listSnus();
  }

  @RequestMapping(value = "/dto", method = RequestMethod.GET)
  public SnusDTO testSnusDTO() {
    return new SnusDTO(2, "DTO snus", "Best Tasting", new Flavour("Spicy"),
        BigDecimal.valueOf(2.50),
        Manufacturer.builder().name("A manufacturer").address(Address.builder().firstLine("The "
            + "Streets").city("Berlin").build()).build(), 20);
  }

}
