package com.englishclass.englishlist.adapters.output;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.englishclass.englishlist.ports.secondary.DatabaseRepository;
import com.englishclass.englishlist.infra.mongoDB.Find;
import com.englishclass.englishlist.infra.mongoDB.Insert;
import com.englishclass.englishlist.infra.mongoDB.Update;

public class DatabaseRepositoryImpl implements DatabaseRepository  {

  private Find find; 
  private Insert insert;
  private Update update;

  public DatabaseRepositoryImpl() {
    this.find = new Find();
    this.insert = new Insert();
    this.update = new Update();
  }

  @Override
  public ListOfCardsDTO insert(ListOfCardsDTO listOfCardsDTO) {
    return this.insert.document(listOfCardsDTO);
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

  @Override
  public ListOfCardsDTO update(String documentId, ListOfCardsDTO listOfCardsDTO) {
    return this.update.document(documentId, listOfCardsDTO);
  }
}
