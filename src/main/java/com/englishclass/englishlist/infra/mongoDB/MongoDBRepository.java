package com.englishclass.englishlist.infra.mongoDB;

import com.englishclass.englishlist.adapters.ListRepository;
import com.englishclass.englishlist.application.model.List;

public class MongoDBRepository implements ListRepository {

  @Override
  public void insert(List list) {
    list.getTitle();
    list.getCards();
  }
}
