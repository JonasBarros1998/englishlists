package com.englishclass.englishlist.infra.mongoDB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;


public class InsertIntegrationTest {

  @Test
  public void document() {
   Insert insert = new Insert();

    CardDTO cardDTO = new CardDTO(
      "minha casa", 
      "123", 
      "casa", 
      "house");
    
    CardDTO secondCard = new CardDTO(
      "minha casa 2.0", 
      "123", 
      "casa full",
      "house 2.0");

    List<CardDTO> list = Arrays.asList(cardDTO, secondCard);

    ListOfCardsDTO dto = new ListOfCardsDTO(
      "My first List", 
      list, 
      true, 
      "1234567", 
      list.size());
   
    ListOfCardsDTO insertDocument = insert.document(dto);

    assertEquals(insertDocument.getTitle(), "My first List");
    assertEquals(insertDocument.getQuantityOfCards(), 2);
    assertTrue(insertDocument.getIsPrivate());
  }
}
