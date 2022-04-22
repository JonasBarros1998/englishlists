package com.englishclass.englishlist.ports.secondary;

import java.util.ArrayList;

import com.englishclass.englishlist.application.model.ListOfCards;

public interface Pagination {
  ArrayList<ListOfCards> find(int limit);
}
