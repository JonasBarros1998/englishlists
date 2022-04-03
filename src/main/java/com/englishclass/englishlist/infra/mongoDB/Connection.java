package com.englishclass.englishlist.infra.mongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Connection {

  @Value("${englishlists.connectionString}")
  private String connectionString;

  public @Bean MongoClient mongoClient() {
       return MongoClients.create(connectionString);
  }
}
