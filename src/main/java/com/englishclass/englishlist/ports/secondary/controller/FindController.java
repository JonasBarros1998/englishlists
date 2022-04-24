package com.englishclass.englishlist.ports.secondary.controller;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.application.factory.RepositoryFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/englishlists")
public class FindController {
  
  @GetMapping(params="quantity")
  public ArrayList<ListOfCardsDTO> find(@RequestParam("quantity") String quantity) {
    RepositoryFactory factory = new RepositoryFactory();
    ArrayList<ListOfCardsDTO> listOfCards = factory
      .buildDatabaseRepository()
      .findListOfCardsWithLimit(quantity);

    return listOfCards;
  }

  @GetMapping
  public ArrayList<ListOfCardsDTO> find() {
    RepositoryFactory factory = new RepositoryFactory();
    
    ArrayList<ListOfCardsDTO> listOfCards = factory
      .buildDatabaseRepository()
      .findAllEnglishList();

    return listOfCards;
  }

  @GetMapping(params = {"lastDocumentId", "quantity"})
  public ArrayList<ListOfCardsDTO> find(
      @RequestParam("lastDocumentId") String lastDocumentId, 
      @RequestParam("quantity") String quantity) {
    RepositoryFactory factory = new RepositoryFactory();

    ArrayList<ListOfCardsDTO> listOfCards = factory
      .buildDatabaseRepository()
      .findEnglishListWithPagination(quantity, lastDocumentId);

    return listOfCards;
  }

  @PostMapping
  public ListOfCardsDTO insert(@RequestBody ListOfCardsDTO formDTO) {
    RepositoryFactory factory = new RepositoryFactory();

    return factory
      .buildDatabaseRepositoryForInserNewEnglishList()
      .insertEnglishList(formDTO);
  }
}
