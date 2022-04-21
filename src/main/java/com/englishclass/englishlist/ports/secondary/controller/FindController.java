package com.englishclass.englishlist.ports.secondary.controller;

import java.util.ArrayList;

import com.englishclass.englishlist.application.factory.RepositoryFactory;
import com.englishclass.englishlist.application.model.ListOfCards;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindController {
  
  @RequestMapping(value="/find", params="quantity")
  public ArrayList<ListOfCards> find(@RequestParam("quantity") String quantity) {
    RepositoryFactory factory = new RepositoryFactory();
    ArrayList<ListOfCards> listOfCards = factory
      .buildDatabaseRepository()
      .findListOfCardsWithLimit(quantity);
  
    return listOfCards;
  }

  @RequestMapping(value="/find")
  public ArrayList<ListOfCards> find() {
    RepositoryFactory factory = new RepositoryFactory();
    ArrayList<ListOfCards> listOfCards = factory
      .buildDatabaseRepository()
      .findAllEnglishList();
    return listOfCards;
  }
}
