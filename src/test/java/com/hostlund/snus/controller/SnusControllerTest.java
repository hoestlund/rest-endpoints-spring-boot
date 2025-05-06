package com.hostlund.snus.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.hostlund.snus.model.Snus;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SnusControllerTest {

  @Autowired
  SnusController controller;

  @Test
  void getSnusById() {
    Snus snus = controller.getSnusById(UUID.randomUUID());
    assertNotNull(snus);
    System.out.println(snus);
  }
}