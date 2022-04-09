package com.englishclass.englishlist.application.DTO;

import java.util.ArrayList;

import org.bson.types.ObjectId;

public class ListOfCardsDTO {
  private String title;
  private ArrayList<CardDTO> cards;
  private ObjectId id;

  public ListOfCardsDTO(String title, ArrayList<CardDTO> cards) {
    this.title = title;
    this.cards = cards;
  }

  public ListOfCardsDTO(String title, ArrayList<CardDTO> cards, ObjectId id) {
    this.title = title;
    this.cards = cards;
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public ArrayList<CardDTO> getListOfCards() {
    return this.cards;
  }

  public ObjectId getId() {
    return this.id;
  }

  public ListOfCardsDTO criarObjectId() {
    this.id = new ObjectId();
    return this;
  }
}
