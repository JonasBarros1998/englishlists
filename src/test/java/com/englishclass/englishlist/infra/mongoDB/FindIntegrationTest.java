package com.englishclass.englishlist.infra.mongoDB;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    assertEquals(find.document(2).size(), 2);
    assertEquals(find.document(1).size(), 1);
  }

  @Test
  public void shouldReturnZeroDocumentsIfThereArentDocumentsForReceiver() {
    Find find = new Find();
    find.document(2).size();
    find.document(2).size();
    find.document(1).size();

    assertEquals(find.document(1).size(), 0);
  }
}
