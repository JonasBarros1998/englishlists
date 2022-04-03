package com.englishclass.englishlist.application.factory;

import com.englishclass.englishlist.application.model.Card;
import com.englishclass.englishlist.application.model.List;


public class ListFactory {

  private List list;

  public ListFactory() {
    this.list = new List();
  }

  public ListFactory addTitle(String title) {
    this.list.setTitle(title);
    return this;
  }

  public ListFactory insertNewCard(Card card) {
    this.list.insertCardInList(card);
    return this;
  }

  public ListFactory create() {
    return this;
  }
}
