package com.hostlund.snus.services;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SnusService {

  void updateSnus(UUID id, SnusDTO snus);

  SnusDTO saveSnus(SnusDTO snus);

  Optional<SnusDTO> getSnusById(UUID id);

  List<SnusDTO> listSnus();

  void deleteSnusById(UUID id);

    void patchSnus(UUID id, SnusDTO snus);
}
