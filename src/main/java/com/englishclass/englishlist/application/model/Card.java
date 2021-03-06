package com.englishclass.englishlist.application.model;

public class Card {

  private String word;
  private String translation;
  private String context;

  public Card(String word, String translation, String context, String id) {
    this.word = word;
    this.translation = translation;
    this.context = context;
  }

  public String getWord() {
    return word;
  }
  
  public String getContext() {
    return context;
  }

  public String getTranslation() {
    return translation;
  }

}
