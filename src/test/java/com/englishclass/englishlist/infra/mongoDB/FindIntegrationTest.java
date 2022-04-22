package com.englishclass.englishlist.infra.mongoDB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindIntegrationTest {

  private static Find find;

  @BeforeEach
  public void createInstance() {
    find = new Find();
  }

  @AfterAll
  public static void closeConnectionWithMongoDB() {
    find.closeConnection();
  }

  @Test
  public void shouldFindAllCardsOnDatabase() {
    ArrayList<ListOfCardsDTO> dto = find.document();
    assertEquals(dto.size(), 5);
  }

  @Test
  public void shouldReturnDocumentPagination() {
    assertEquals(find.document(2).size(), 2);
    assertEquals(find.getHasNextDocument(), true);
  }

  @Test
  public void shouldReturnZeroDocumentsIfExistDocumentsForGet() {
    ArrayList<ListOfCardsDTO> firstPage = find.document(2);
    ArrayList<ListOfCardsDTO> secondPage = find.document(3, firstPage.get(firstPage.size() - 1).getId());
    ArrayList<ListOfCardsDTO> thirdPage = find.document(1, secondPage.get(secondPage.size() - 1).getId());
    assertEquals(thirdPage.size(), 0);
    assertFalse(find.getHasNextDocument());
  }
}
