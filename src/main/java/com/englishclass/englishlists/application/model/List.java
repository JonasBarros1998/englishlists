package com.englishclass.englishlists.application.model;
import java.util.ArrayList;

public class List {
  private final String title;
  private ArrayList<Card> insertCardInList;

  public List(String title) {
    this.insertCardInList = new ArrayList<Card>();
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
