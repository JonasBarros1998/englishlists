package com.englishclass.englishlists.application.model;
import java.util.ArrayList;

public class List {
  private String title;
  private ArrayList<Card> insertCardInList;

  public List() {
    this.insertCardInList = new ArrayList<Card>();
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void insertCardInList(String word, String context, String translation) {
    this.insertCardInList.add(new Card(word, context, translation));
  }

  public ArrayList<Card> getCards() {
    return this.insertCardInList;
  }
}
