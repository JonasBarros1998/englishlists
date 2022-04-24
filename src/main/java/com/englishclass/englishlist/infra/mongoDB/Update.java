package com.englishclass.englishlist.infra.mongoDB;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Update extends MongoDBRepository {

  private MongoCollection<Document> collection; 
  
  public Update() {
    super();
    this.collection = openConnection()
        .getDatabase("englishlists")
        .getCollection("lists");
  }

  public ListOfCardsDTO document(String documentId, ListOfCardsDTO listOfCardsDTO) {
    ObjectId objectId = new ObjectId(documentId);

    Document document = ConvertListOfCardsToMongoDBDocument.convert(listOfCardsDTO);

    this.collection.updateOne(
      Filters.eq("_id", objectId), 
      new Document("$set", document)
    );

    return listOfCardsDTO;
  }
}
