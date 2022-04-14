package com.englishclass.englishlist.infra.mongoDB;

import com.mongodb.client.MongoClient;

abstract public class MongoDBRepository {

  private MongoClient mongoClient;
  private final Connection connection;

  public MongoDBRepository() {
    this.connection = new Connection();
  }
  
  protected MongoClient openConnection() {
    this.mongoClient = this.connection.mongoClient();
    return this.mongoClient;
  }

  protected void closeConnection() {
    this.mongoClient.close();
  }
}
