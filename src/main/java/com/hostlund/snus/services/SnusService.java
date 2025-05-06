package com.hostlund.snus.services;

import com.hostlund.snus.model.Snus;
import java.util.List;
import java.util.UUID;

public interface SnusService {

  Snus getSnusById(UUID id);

  List<Snus> listSnus();

}
