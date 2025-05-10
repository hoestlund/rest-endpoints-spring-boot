package com.hostlund.snus.controller;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/snus")
public class SnusController {

  private final SnusService snusService;

  @PostMapping()
  public ResponseEntity handlePost(SnusDTO snus) {
    Snus savedSnus = snusService.saveNewSnus(snus);
    return new ResponseEntity(HttpStatus.ACCEPTED);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Snus getSnusById(@PathVariable("id") UUID id) {
    return snusService.getSnusById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Snus> getSnus() {
    return snusService.listSnus();
  }

}
