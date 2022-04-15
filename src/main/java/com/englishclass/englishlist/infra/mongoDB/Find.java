package com.englishclass.englishlist.infra.mongoDB;

import java.util.ArrayList;
import java.util.List;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.Document;

public class Find extends MongoDBRepository {
  
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

    while(cursor.hasNext()) {
      Document document = cursor.next();
      List<Document> documentOfCards = document.getList("cards", Document.class);
      ArrayList<CardDTO> cards = this.dtoCardsIntegration(documentOfCards);
      lists.add(this.dtoListOfCardsIntegration(cards, document));
    }
    super.closeConnection();
    return lists;
  }

  public void document(int limit) {
    // criar paginação
  }
}
