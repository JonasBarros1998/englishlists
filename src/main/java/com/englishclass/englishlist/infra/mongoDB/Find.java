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

  public ArrayList<ListOfCardsDTO> document() {
    ArrayList<ListOfCardsDTO> cursorList = new ArrayList<ListOfCardsDTO>();
    ArrayList<CardDTO> listOfCards = new ArrayList<CardDTO>();

    MongoCollection<Document> collection = super.openConnection()
      .getDatabase("englishlists")
      .getCollection("lists");
    
    MongoCursor<Document> cursor = collection.find().iterator();
    
      while(cursor.hasNext()) {

        Document document = cursor.next();
        List<Document> cards = document.getList("cards", Document.class);

        cards.forEach(card -> {
          CardDTO cartDTO = new CardDTO(
            card.get("word").toString(),
            card.get("translation").toString(),
            card.get("context").toString(),
            card.get("id").toString()
          );

          listOfCards.add(cartDTO);
        });


        int quantityCards = (int)document.getInteger("quantityCards");
        
        ListOfCardsDTO listOfCardsDTO = new ListOfCardsDTO(
          document.get("title").toString(),
          listOfCards,
          document.getBoolean("isPrivate"),
          document.get("userId").toString(),
          quantityCards,
          document.getObjectId("_id")
        );

        cursorList.add(listOfCardsDTO);
      }

    super.closeConnection();
    return cursorList;
  }
}
