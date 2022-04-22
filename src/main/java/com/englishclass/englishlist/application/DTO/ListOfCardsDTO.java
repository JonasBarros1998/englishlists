package com.englishclass.englishlist.application.DTO;

import java.util.List;

public class ListOfCardsDTO {
  private String title;
  private List<CardDTO> cards;
  private String id;
  private boolean isPrivate;
  private String userId;
  private int quantityOfCards;

  public ListOfCardsDTO(String title, List<CardDTO> cards, Boolean isPrivate, String userId, int quantityOfCards) {
    this.title = title;
    this.cards = cards;
    this.userId = userId;
    this.quantityOfCards = quantityOfCards;
    this.isPrivate = isPrivate;

  }

  public ListOfCardsDTO(String title, List<CardDTO> cards, Boolean isPrivate, String userId, int quantityOfCards, String id) {
    this.title = title;
    this.cards = cards;
    this.id = id;
    this.isPrivate = isPrivate;
    this.userId = userId;
    this.quantityOfCards = quantityOfCards;
  }

  public String getTitle() {
    return this.title;
  }

  public List<CardDTO> getListOfCards() {
    return this.cards;
  }

  public String getId() {
    return this.id;
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

  public ListOfCardsDTO criarObjectId() {
    this.id = new String();
    return this;
  }
}
