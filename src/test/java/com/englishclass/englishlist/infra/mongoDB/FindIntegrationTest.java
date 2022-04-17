package com.englishclass.englishlist.infra.mongoDB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

import org.junit.jupiter.api.Test;

public class FindIntegrationTest {

  @Test
  public void shouldFindAllCardsOnDatabase() {
    Find find = new Find();
    ArrayList<ListOfCardsDTO> dto = find.document();
    assertEquals(dto.size(), 5);
  }

  @Test
  public void shouldReturnDocumentPagination() {
    Find find = new Find();
    assertEquals(find.document(2).size(), 2);
    assertEquals(find.getHasNextDocument(), true);
  }

  @Test
  public void shouldReturnZeroDocumentsIfExistDocumentsForGet() {
    Find find = new Find();
    ArrayList<ListOfCardsDTO> firstPage = find.document(2);
    ArrayList<ListOfCardsDTO> secondPage = find.document(3, firstPage.get(firstPage.size() - 1).getId());
    ArrayList<ListOfCardsDTO> thirdPage = find.document(1, secondPage.get(secondPage.size() - 1).getId());
    assertEquals(thirdPage.size(), 0);
    assertFalse(find.getHasNextDocument());
  }
}
