package com.englishclass.englishlist.infra.mongoDB;

import java.util.ArrayList;
import java.util.List;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.gt;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Find extends MongoDBRepository {

  private boolean hasNextDocument;
  private MongoCursor<Document> cursorPagination;
  
  public Find() {
    super();
  }

  private ListOfCardsDTO dtoListOfCardsIntegration(ArrayList<CardDTO> cards, Document document) {
    int quantityCards = (int)document.getInteger("quantityCards");
    ListOfCardsDTO listOfCardsDTO = new ListOfCardsDTO(
      document.get("title").toString(),
      cards,
      document.getBoolean("isPrivate"),
      document.get("userId").toString(),
      quantityCards,
      document.getObjectId("_id")
    );
    
    return listOfCardsDTO;
  }

  private ArrayList<CardDTO> dtoCardsIntegration(List<Document> cards) {
    ArrayList<CardDTO> listOfCards = new ArrayList<CardDTO>();

    cards.forEach(card -> {
      CardDTO cartDTO = new CardDTO(
        card.get("word").toString(),
        card.get("translation").toString(),
        card.get("context").toString(),
        card.get("id").toString()
      );
      listOfCards.add(cartDTO);
    });

    return listOfCards;
  }

  public ArrayList<ListOfCardsDTO> document() {
    ArrayList<ListOfCardsDTO> lists = new ArrayList<ListOfCardsDTO>();

    MongoCollection<Document> collection = super.openConnection()
      .getDatabase("englishlists")
      .getCollection("lists");
    
    MongoCursor<Document> cursor = collection.find().iterator();

    if (cursor.hasNext() == false) {
      this.setHasNextDocument(false);
      return lists;
    }

    while(cursor.hasNext()) {
      Document document = cursor.next();
      List<Document> documentOfCards = document.getList("cards", Document.class);
      ArrayList<CardDTO> cards = this.dtoCardsIntegration(documentOfCards);
      lists.add(this.dtoListOfCardsIntegration(cards, document));
    }
    super.closeConnection();
    return lists;
  }


  public ArrayList<ListOfCardsDTO> document(int limit) {
    ArrayList<ListOfCardsDTO> lists = new ArrayList<ListOfCardsDTO>();

    MongoCollection<Document> collection = super.openConnection()
      .getDatabase("englishlists")
      .getCollection("lists");
    
    MongoCursor<Document> cursor = collection.find().limit(limit).iterator();

    while(cursor.hasNext()) {
      Document document = cursor.next();
      List<Document> documentOfCards = document.getList("cards", Document.class);
      ArrayList<CardDTO> cards = this.dtoCardsIntegration(documentOfCards);
      lists.add(this.dtoListOfCardsIntegration(cards, document));
    }
    super.closeConnection();
    return lists;
  }

  public ArrayList<ListOfCardsDTO> document(int limit, ObjectId lastDocumentId) {
    ArrayList<ListOfCardsDTO> lists = new ArrayList<ListOfCardsDTO>();
    
    MongoCollection<Document> collection = super.openConnection()
      .getDatabase("englishlists")
      .getCollection("lists");

    this.cursorPagination = collection.find(gt("_id", lastDocumentId)).limit(limit).iterator();

    if (this.cursorPagination.hasNext() == false) {
      this.setHasNextDocument(false);
      return lists;
    }
    
    while (this.cursorPagination.hasNext()) {
      Document document = this.cursorPagination.next();
      List<Document> documentOfCards = document.getList("cards", Document.class);
      ArrayList<CardDTO> cards = this.dtoCardsIntegration(documentOfCards);
      lists.add(this.dtoListOfCardsIntegration(cards, document));
    }

    ListOfCardsDTO lastElement = lists.get(lists.size() - 1);
    System.out.println("-------" + lastElement.getId());
    this.existNextDocument(lastElement.getId());
    super.closeConnection();
    return lists;
  }

  private void setHasNextDocument(boolean nextDocument) {
    this.hasNextDocument = nextDocument;
  }

  public boolean getHasNextDocument() {
    return this.hasNextDocument;
  }

  private void existNextDocument(ObjectId lastDocumentId) {
    MongoCollection<Document> collection = super.openConnection()
      .getDatabase("englishlists")
      .getCollection("lists");
    
    MongoCursor<Document> document = collection
      .find(gt("_id", lastDocumentId))
      .limit(1)
      .iterator();
    
    this.setHasNextDocument(document.hasNext());
  }

}
