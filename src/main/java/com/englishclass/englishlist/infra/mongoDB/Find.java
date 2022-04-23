package com.englishclass.englishlist.infra.mongoDB;

import java.util.ArrayList;
import java.util.List;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.gt;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Find extends MongoDBRepository {

  private boolean hasNextDocument;
  private MongoCursor<Document> cursorPagination;
  private MongoCollection<Document> collection; 
  
  public Find() {
    super();
    this.collection = super.openConnection()
                      .getDatabase("englishlists")
                      .getCollection("lists");
  }

  private ListOfCardsDTO dtoListOfCardsIntegration(ArrayList<CardDTO> cards, Document document) {
    int quantityCards = (int)document.getInteger("quantityCards");
    ListOfCardsDTO listOfCardsDTO = new ListOfCardsDTO(
      document.get("title").toString(),
      cards,
      document.getBoolean("isPrivate"),
      document.get("userId").toString(),
      quantityCards,
      document.getObjectId("_id").toHexString()
    );
    
    return listOfCardsDTO;
  }

  private ArrayList<CardDTO> dtoCardsIntegration(List<Document> cards) {
    ArrayList<CardDTO> listOfCards = new ArrayList<CardDTO>();

    cards.forEach(card -> {
      CardDTO cartDTO = new CardDTO(
        card.get("context").toString(),
        card.get("id").toString(),
        card.get("translation").toString(),
        card.get("word").toString()
      );
      listOfCards.add(cartDTO);
    });

    return listOfCards;
  }

  public ArrayList<ListOfCardsDTO> document() {
    ArrayList<ListOfCardsDTO> lists = new ArrayList<ListOfCardsDTO>();
    
    MongoCursor<Document> cursor = this.collection.find().iterator();

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
    // super.closeConnection();
    return lists;
  }


  public ArrayList<ListOfCardsDTO> document(int limit) {
    ArrayList<ListOfCardsDTO> lists = new ArrayList<ListOfCardsDTO>();
    
    MongoCursor<Document> cursor = this.collection.find().limit(limit).iterator();

    while(cursor.hasNext()) {
      Document document = cursor.next();
      List<Document> documentOfCards = document.getList("cards", Document.class);
      ArrayList<CardDTO> cards = this.dtoCardsIntegration(documentOfCards);
      lists.add(this.dtoListOfCardsIntegration(cards, document));
    }

    ListOfCardsDTO lastElement = lists.get(lists.size() - 1);
    this.existNextDocument(lastElement.getId());

    // super.closeConnection();
    return lists;
  }

  public ArrayList<ListOfCardsDTO> document(int limit, String lastDocumentId) {
    ArrayList<ListOfCardsDTO> lists = new ArrayList<ListOfCardsDTO>();
    
    ObjectId lastDocumentObjectId = new ObjectId(lastDocumentId);
    this.cursorPagination = this.collection.find(gt("_id", lastDocumentObjectId)).limit(limit).iterator();
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
    this.existNextDocument(lastElement.getId());
    return lists;
  }

  private void setHasNextDocument(boolean nextDocument) {
    this.hasNextDocument = nextDocument;
  }

  public boolean getHasNextDocument() {
    return this.hasNextDocument;
  }

  private void existNextDocument(String lastDocumentId) {
    ObjectId lastDocumentObjectId = new ObjectId(lastDocumentId);
    MongoCursor<Document> document = this.collection
      .find(gt("_id", lastDocumentObjectId))
      .limit(1)
      .iterator();
    
    this.setHasNextDocument(document.hasNext());
  }

}
