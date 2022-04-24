package com.englishclass.englishlist.infra.mongoDB;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Insert extends MongoDBRepository {
  
  private MongoCollection<Document> collection; 
  
  public Insert() {
    super();
    this.collection = super.openConnection()
      .getDatabase("englishlists")
      .getCollection("lists");
  }

  public ListOfCardsDTO document(ListOfCardsDTO listOfCardsDTO) {
    Document document = new Document();
    ArrayList<Document> listDocumentOfCards = new ArrayList<Document>();

    document.put("title", listOfCardsDTO.getTitle());
    document.put("isPrivate", listOfCardsDTO.getIsPrivate());
    document.put("userId", listOfCardsDTO.getUserId());
    document.put("quantityCards", listOfCardsDTO.getQuantityOfCards());

    this.insertObjectIdInEnglishList(listOfCardsDTO);

    listOfCardsDTO.getCards().stream().forEach(card -> {
      ObjectId cardId = this.insertObjectIdInCard(card);
      Document documentOfCard = new Document()
        .append("_id", cardId)
        .append("word", card.getWord())
        .append("context", card.getContext())
        .append("translation", card.getTranslation());

      listDocumentOfCards.add(documentOfCard);
    });
    document.put("cards", listDocumentOfCards);
    
    this.collection.insertOne(document);

    return listOfCardsDTO;
  }


  private ObjectId insertObjectIdInCard(CardDTO cardDto) {
    ObjectId cardObjectId = new ObjectId();
    cardDto.setId(cardObjectId.toHexString());
    return cardObjectId;
  }

  private ObjectId insertObjectIdInEnglishList(ListOfCardsDTO dto) {
    ObjectId createId = new ObjectId();
    dto.setId(createId.toHexString());
    return createId;
  }

}
