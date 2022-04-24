package com.englishclass.englishlist.adapters.output;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.ports.secondary.DatabaseRepository;
import com.englishclass.englishlist.infra.mongoDB.Find;
import com.englishclass.englishlist.infra.mongoDB.Insert;

public class DatabaseRepositoryImpl implements DatabaseRepository  {

  private Find find; 
  private Insert insert;

  public DatabaseRepositoryImpl() {
    this.find = new Find();
    this.insert = new Insert();
  }

  @Override
  public void insert(ListOfCardsDTO listOfCardsDTO) {
    this.insert.document(listOfCardsDTO);
  }

  @Override
  public ArrayList<ListOfCardsDTO> find(int limit) {
    ArrayList<ListOfCardsDTO> listOfCardsDTO = this.find.document(limit);
    return listOfCardsDTO;
  }

  @Override
  public ArrayList<ListOfCardsDTO> find() {
    ArrayList<ListOfCardsDTO> listOfCardsDTO = this.find.document();
    return listOfCardsDTO;
  }

  @Override
  public ArrayList<ListOfCardsDTO> find(int limit, String id) {
    ArrayList<ListOfCardsDTO> listOfCardsDTO = this.find.document(limit, id);
    return listOfCardsDTO;
  }
}
