package com.englishclass.englishlist.ports.secondary;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

public interface DatabaseRepository {
  ListOfCardsDTO insert(ListOfCardsDTO list);
  ListOfCardsDTO update(String documentId, ListOfCardsDTO list);
  ArrayList<ListOfCardsDTO> find();
  ArrayList<ListOfCardsDTO> find(int limit);
  ArrayList<ListOfCardsDTO> find(int limit, String id);
}
