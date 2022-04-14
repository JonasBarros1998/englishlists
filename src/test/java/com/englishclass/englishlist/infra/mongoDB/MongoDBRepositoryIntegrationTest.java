package com.englishclass.englishlist.infra.mongoDB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

import org.junit.jupiter.api.Test;

public class MongoDBRepositoryIntegrationTest {

  @Test
  public void shouldFindAllCardsOnDatabase() {
    Find mongodb = new Find();
    ArrayList<ListOfCardsDTO> dto = mongodb.document();
    assertEquals(dto.size(), 3);
  }

  @Test
  public void shouldFindCardsForPagination() {}

}
