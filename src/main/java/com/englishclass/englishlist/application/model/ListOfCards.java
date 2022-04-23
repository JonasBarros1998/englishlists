package com.englishclass.englishlist.application.model;
import java.util.ArrayList;

public class ListOfCards {
  private String title;
  private final ArrayList<Card> insertCardInList;
  private Boolean isPrivate;
  private int quantityOfCards;
  private String userId;

  public int getQuantityOfCards() {
    return quantityOfCards;
  }

  public void setQuantityOfCards(int quantity) {
    this.quantityOfCards = quantity;
  }

  public void setIsPrivate(boolean isProvate) {
    this.isPrivate = isProvate;
  }

  public Boolean getIsPrivate() {
    return isPrivate;
  }

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

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return this.userId;
  }

}
