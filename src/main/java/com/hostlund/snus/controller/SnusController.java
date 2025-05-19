package com.hostlund.snus.controller;

import static com.hostlund.snus.services.SnusService.DTOToSnus;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/snus")
public class SnusController {

  private final SnusService snusService;

  @PostMapping
  public ResponseEntity<SnusDTO> handlePost(@Valid @RequestBody SnusDTO snus,
      UriComponentsBuilder uriBuilder) {
    Snus savedSnus = snusService.saveSnus(DTOToSnus(snus));
    URI location = uriBuilder.path("api/v1/snus/{id}")
        .buildAndExpand(savedSnus.getId())
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @GetMapping(value = "/{id}")
  public Snus getSnusById(@PathVariable("id") UUID id) {
    return snusService.getSnusById(id);
  }

  @GetMapping
  public List<Snus> getSnus() {
    return snusService.listSnus();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity updateSnus(@PathVariable UUID id, @RequestBody @NotNull SnusDTO snus) {
    try {
      //Change the update fields, version etc.
      snusService.updateSnus(id, DTOToSnus(snus));
    } catch (ResponseStatusException e) {
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity(HttpStatus.OK);
  }

}
