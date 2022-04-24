package com.englishclass.englishlist.application.useCase;

import java.util.ArrayList;
import java.util.List;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.application.factory.ListFactory;
import com.englishclass.englishlist.application.model.ListOfCards;
import com.englishclass.englishlist.ports.secondary.DatabaseRepository;

public class FindListOfCardsOnDatabase {

  private DatabaseRepository repository;

  public FindListOfCardsOnDatabase(DatabaseRepository repository) {
    this.repository = repository;
  }
  
  public ArrayList<ListOfCardsDTO> findListOfCardsWithLimit(String quantity) {
    int quantityOfList = Integer.parseInt(quantity);
    ArrayList<ListOfCardsDTO> listOfCardsDTO = this.repository.find(quantityOfList);
    this.findListsOnDatabase(listOfCardsDTO);
    return listOfCardsDTO;
  }

  public ArrayList<ListOfCardsDTO> findAllEnglishList() {
    ArrayList<ListOfCardsDTO> listOfCardsDTO = this.repository.find();
    this.findListsOnDatabase(listOfCardsDTO);
    return listOfCardsDTO;
  }

  public ArrayList<ListOfCardsDTO> findEnglishListWithPagination(String quantity, String lastDocumentId) {
    int quantityOfList = Integer.parseInt(quantity);
    ArrayList<ListOfCardsDTO> listOfCardsDTO = this.repository.find(quantityOfList, lastDocumentId);
    this.findListsOnDatabase(listOfCardsDTO);
    return listOfCardsDTO;
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
    factory
      .addTitle(listOfCardDTO.getTitle())
      .addQuantity(listOfCardDTO.getQuantityOfCards())
      .addIsPrivate(listOfCardDTO.getIsPrivate());

    return factory;
  }

  private ArrayList<ListOfCards> findListsOnDatabase(ArrayList<ListOfCardsDTO> listOfCardsDTO) {
    ArrayList<ListOfCards> listOfCards = new ArrayList<ListOfCards>();
    ListFactory factory = new ListFactory();

    for (ListOfCardsDTO item : listOfCardsDTO) {
      this.createListOfCards(item, factory);
      this.createCard(item.getCards(), factory);
      listOfCards.add(factory.create());
    }
    return listOfCards;
  }
}
