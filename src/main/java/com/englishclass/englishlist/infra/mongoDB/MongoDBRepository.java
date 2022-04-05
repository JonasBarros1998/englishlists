package com.englishclass.englishlist.infra.mongoDB;

import com.englishclass.englishlist.adapters.ListRepository;
import com.englishclass.englishlist.application.model.ListOfCards;

public class MongoDBRepository implements ListRepository {

  @Override
  public void insert(ListOfCards list) {
    list.getTitle();
    list.getCards();
  }
}
