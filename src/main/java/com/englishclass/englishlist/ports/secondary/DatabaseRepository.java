package com.englishclass.englishlist.ports.secondary;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

public interface DatabaseRepository {
  void insert(ListOfCardsDTO list);
  ArrayList<ListOfCardsDTO> find();
  ArrayList<ListOfCardsDTO> find(int limit);
}
