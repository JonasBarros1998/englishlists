package com.englishclass.englishlist.application.useCase;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.application.factory.ListFactory;
import com.englishclass.englishlist.ports.secondary.DatabaseRepository;

public class UpdateEnglishListOnDatabase {
  private DatabaseRepository repository;
  private ListFactory factory;
  
  public UpdateEnglishListOnDatabase(DatabaseRepository repository) {
    this.repository = repository;
    this.factory = new ListFactory();
  }

  public ListOfCardsDTO updateEnglishList(String documentId, ListOfCardsDTO dto) {
    ListOfCardsDTO listOfCardsDTO = this.factory.toListOfCardsDTO(dto);
    return this.repository.update(documentId, listOfCardsDTO);
  }
}
