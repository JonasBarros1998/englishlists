package com.englishclass.englishlist.application.DTO;

import java.util.List;

public class ListOfCardsDTO {
  private String title;
  private List<CardDTO> cards;
  private String id;
  private boolean isPrivate;
  private String userId;
  private int quantityOfCards;

  public ListOfCardsDTO() {}

  public ListOfCardsDTO(String title, List<CardDTO> cards, Boolean isPrivate, String userId, int getQuantityOfCards) {
    this.title = title;
    this.cards = cards;
    this.userId = userId;
    this.quantityOfCards = getQuantityOfCards;
    this.isPrivate = isPrivate;

  }

  public ListOfCardsDTO(String title, List<CardDTO> cards, Boolean isPrivate, String userId, int getQuantityOfCards, String id) {
    this.title = title;
    this.cards = cards;
    this.id = id;
    this.isPrivate = isPrivate;
    this.userId = userId;
    this.quantityOfCards = getQuantityOfCards;
  }

  public String getTitle() {
    return this.title;
  }

  public List<CardDTO> getCards() {
    return this.cards;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean getIsPrivate() {
    return this.isPrivate;
  }

  public int getQuantityOfCards() {
    return this.quantityOfCards;
  }

  public String getUserId() {
    return this.userId;
  }

}
