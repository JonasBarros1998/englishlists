package com.englishclass.englishlist.application.DTO;

public class CardDTO {
  private String word;
  private String translation;
  private String context;
  private String id;

  public CardDTO(String context, String id, String translation, String word) {
    this.word = word;
    this.translation = translation;
    this.context = context;
    this.id = id;
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

  public String getId() {
    return id;
  }
}
