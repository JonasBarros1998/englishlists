package com.englishclass.englishlist.application.model;
import java.util.ArrayList;

public class ListOfCards {
  private String title;
  private ArrayList<Card> insertCardInList;

  public ListOfCards() {
    this.insertCardInList = new ArrayList<Card>();
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public void insertCardInList(Card card) {
    this.insertCardInList.add(card);
  }

  public ArrayList<Card> getCards() {
    return this.insertCardInList;
  }
}
