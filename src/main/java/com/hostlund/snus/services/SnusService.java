package com.hostlund.snus.services;

import com.hostlund.snus.dto.SnusDTO;
import com.hostlund.snus.model.Snus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SnusService {

  void updateSnus(UUID id, Snus snus);

  Snus saveSnus(Snus snus);

  Optional<Snus> getSnusById(UUID id);

  List<Snus> listSnus();

  void deleteSnusById(UUID id);

    void patchSnus(UUID id, Snus snus);
}
