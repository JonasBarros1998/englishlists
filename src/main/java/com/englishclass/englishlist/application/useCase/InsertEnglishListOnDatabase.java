package com.englishclass.englishlist.application.useCase;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.application.factory.ListFactory;
import com.englishclass.englishlist.ports.secondary.DatabaseRepository;

public class InsertEnglishListOnDatabase {

  private DatabaseRepository repository;
  private ListFactory factory;

  public InsertEnglishListOnDatabase(DatabaseRepository repository) {
    this.repository = repository;
    this.factory = new ListFactory();
  }
  
  public ListOfCardsDTO insertEnglishList(ListOfCardsDTO dto) {
    this.factory
      .addTitle(dto.getTitle())
      .addIsPrivate(dto.getIsPrivate())
      .addQuantity(dto.getQuantityOfCards());

    for (CardDTO card : dto.getCards()) {
      this.factory.addCard(
        card.getId(), 
        card.getWord(), 
        card.getTranslation(),
        card.getContext()
      );
    }
    this.factory.create();

    return this.repository.insert(dto);
  }
}
