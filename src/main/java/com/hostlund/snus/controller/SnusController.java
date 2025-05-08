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

    List<Snus> snusList = snusService.listSnus();
    //this is not reliable. Didn't think about the fact that I am
    // using Map in the caller
    // Snus pine = snusList.get(2);

    Snus pine = snusList.stream().filter(s -> "Pine".equals(s.getName())).toList().getFirst();

    System.out.println(
        pine); //here I see the string of my flavour to string flavour=Flavour(name=Pine)
    System.out.println("!!!!!!!!!!!! Printing flavour");
    System.out.println(pine.getFlavour()); //here it is null

    return snusService.listSnus();
  }

}
