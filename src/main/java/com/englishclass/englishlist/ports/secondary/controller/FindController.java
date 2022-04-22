package com.englishclass.englishlist.ports.secondary.controller;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.application.factory.RepositoryFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindController {
  
  @RequestMapping(value="/find", params="quantity")
  public ArrayList<ListOfCardsDTO> find(@RequestParam("quantity") String quantity) {
    RepositoryFactory factory = new RepositoryFactory();
    ArrayList<ListOfCardsDTO> listOfCards = factory
      .buildDatabaseRepository()
      .findListOfCardsWithLimit(quantity);
    System.out.println("find default");
    return listOfCards;
  }

  @RequestMapping(value="/find")
  public ArrayList<ListOfCardsDTO> find() {
    RepositoryFactory factory = new RepositoryFactory();
    
    ArrayList<ListOfCardsDTO> listOfCards = factory
      .buildDatabaseRepository()
      .findAllEnglishList();

    return listOfCards;
  }

  @RequestMapping(value="/find", params = {"lastDocumentId", "quantity"})
  public ArrayList<ListOfCardsDTO> find(
      @RequestParam("lastDocumentId") String lastDocumentId, 
      @RequestParam("quantity") String quantity) {
    RepositoryFactory factory = new RepositoryFactory();

    ArrayList<ListOfCardsDTO> listOfCards = factory
      .buildDatabaseRepository()
      .findEnglishListWithPagination(quantity, lastDocumentId);

    return listOfCards;
  }
}
