package com.hostlund.snus.controller;

import static com.hostlund.snus.services.SnusService.DTOToSnus;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.services.SnusService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
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
        Snus result =  snusService.getSnusById(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Snus not found");
        }
        return result;
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteSnus(@PathVariable UUID id) {
        try {
            snusService.deleteSnusById(id);
        } catch (ResponseStatusException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity patchSnus(@PathVariable UUID id, @RequestBody @NotNull SnusDTO snus) {

        snusService.patchSnus(id, DTOToSnus(snus));
        return ResponseEntity.noContent().build();
    }

}
