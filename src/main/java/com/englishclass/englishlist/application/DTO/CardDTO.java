package com.englishclass.englishlist.application.DTO;

public class CardDTO {
  private String word;
  private String translation;
  private String context;
  private String id;

  public CardDTO(String context, String id, String translation, String word) {
    this.context = context;
    this.id = id;
    this.translation = translation;
    this.word = word;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }
  
  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getTranslation() {
    return translation;
  }

  public void setTranslation(String translation) {
    this.translation = translation;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
