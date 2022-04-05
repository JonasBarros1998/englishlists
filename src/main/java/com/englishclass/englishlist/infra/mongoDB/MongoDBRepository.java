package com.englishclass.englishlist.infra.mongoDB;

import com.englishclass.englishlist.adapters.output.ListOfCardsRepository;
import com.englishclass.englishlist.application.model.ListOfCards;

public class MongoDBRepository implements ListOfCardsRepository {

  @Override
  public void insert(ListOfCards list) {
    list.getTitle();
    list.getCards();
  }
}
