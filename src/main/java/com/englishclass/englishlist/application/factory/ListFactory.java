package com.englishclass.englishlist.application.factory;

import com.englishclass.englishlist.application.model.Card;
import com.englishclass.englishlist.application.model.ListOfCards;


public class ListFactory {

  private ListOfCards list;

  public ListFactory() {
    this.list = new ListOfCards();
  }

  public ListFactory addTitle(String title) {
    this.list.setTitle(title);
    return this;
  }

  public ListFactory addIsPrivate(boolean isPrivate) {
    this.list.setIsPrivate(isPrivate);
    return this;
  }

  public ListFactory insertNewCard(Card card) {
    this.list.insertCardInList(card);
    return this;
  }

  public ListFactory addQuantity(int quantity) {
    this.list.setQuantityOfCards(quantity);
    return this;
  }

  public ListFactory addCard(String id, String word, String translation, String context) {
    Card card = new Card(word, translation, context);
    this.list.insertCardInList(card);
    return this;
  }

  public ListOfCards create() {
    return this.list;
  }
}
