package com.englishclass.englishlist.application.useCase;

import java.util.ArrayList;
import java.util.List;

import com.englishclass.englishlist.adapters.output.DatabaseRepositoryImpl;
import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.application.factory.ListFactory;
import com.englishclass.englishlist.application.model.ListOfCards;

public class findListOfCardsOnDatabase {
  
  public ArrayList<ListOfCards> findListOfCardsWithLimit() {
    ArrayList<ListOfCards> listOfCards = new ArrayList<ListOfCards>();
    ListFactory factory = new ListFactory();
    DatabaseRepositoryImpl repository = new DatabaseRepositoryImpl();
    ArrayList<ListOfCardsDTO> listOfCardsDTO = repository.find(2);

    for (ListOfCardsDTO item : listOfCardsDTO) {
      this.createListOfCards(item, factory);
      this.createCard(item.getListOfCards(), factory);
      listOfCards.add(factory.create());
    }

    return listOfCards;
  }


  private ListFactory createCard(List<CardDTO> cards, ListFactory factory) {
    for (CardDTO cardItem : cards) {
      factory.addCard(cardItem.getId(), 
        cardItem.getWord(), 
        cardItem.getTranslation(),
        cardItem.getContext());
    }

    return factory;
  }

  private ListFactory createListOfCards(ListOfCardsDTO listOfCardDTO, ListFactory factory) {
    factory.addTitle(listOfCardDTO.getTitle())
      .addQuantity(listOfCardDTO.getQuantityOfCards())
      .addIsPrivate(listOfCardDTO.getIsPrivate());

    return factory;
  }
}
