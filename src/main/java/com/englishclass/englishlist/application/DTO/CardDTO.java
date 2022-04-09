package com.englishclass.englishlist.application.DTO;

public class CardDTO {
  private String word;
  private String translation;
  private String context;

  public CardDTO(String word, String translation, String context) {
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
