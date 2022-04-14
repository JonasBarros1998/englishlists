package com.englishclass.englishlist.infra.mongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {

  public MongoClient mongoClient() {
    return MongoClients.create("mongodb://0.0.0.0:27017/?maxPoolSize=20");
  }
}
