package com.englishclass.englishlist.infra.mongoDB;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

import org.bson.Document;

public class ConvertListOfCardsToMongoDBDocument {

  public static Document convert(ListOfCardsDTO listOfCardsDTO) {
    Document document = new Document();
    ArrayList<Document> listDocumentOfCards = new ArrayList<Document>();
    
    document.put("title", listOfCardsDTO.getTitle());
    document.put("isPrivate", listOfCardsDTO.getIsPrivate());
    document.put("userId", listOfCardsDTO.getUserId());
    document.put("quantityCards", listOfCardsDTO.getQuantityOfCards());

    listOfCardsDTO.getCards().stream().forEach(card -> {
      Document documentOfCard = new Document()
        .append("word", card.getWord())
        .append("context", card.getContext())
        .append("translation", card.getTranslation());

      listDocumentOfCards.add(documentOfCard);
    });

    document.put("cards", listDocumentOfCards);
    return document;
  }

}
