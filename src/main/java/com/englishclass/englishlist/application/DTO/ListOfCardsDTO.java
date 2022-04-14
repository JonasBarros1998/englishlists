package com.englishclass.englishlist.application.DTO;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class ListOfCardsDTO {
  private String title;
  private List<CardDTO> cards;
  private ObjectId id;
  private Boolean isPrivate;
  private String userId;
  private int quantityOfCards;

  public ListOfCardsDTO(String title, List<CardDTO> cards, Boolean isPrivate, String userId, int quantityOfCards) {
    this.title = title;
    this.cards = cards;
    this.userId = userId;
    this.quantityOfCards = quantityOfCards;
    this.isPrivate = isPrivate;

  }

  public ListOfCardsDTO(String title, List<CardDTO> cards, Boolean isPrivate, String userId, int quantityOfCards, ObjectId id) {
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

  public ObjectId getId() {
    return this.id;
  }

  public Boolean getIsPrivate() {
    return this.isPrivate;
  }

  public int getQuantityOfCards() {
    return this.quantityOfCards;
  }

  public String getUserId() {
    return this.userId;
  }

  public ListOfCardsDTO criarObjectId() {
    this.id = new ObjectId();
    return this;
  }
}
