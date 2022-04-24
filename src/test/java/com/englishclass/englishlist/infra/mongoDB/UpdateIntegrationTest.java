package com.englishclass.englishlist.infra.mongoDB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import com.englishclass.englishlist.application.DTO.CardDTO;
import com.englishclass.englishlist.application.DTO.ListOfCardsDTO;

import org.junit.jupiter.api.Test;

public class UpdateIntegrationTest {
  
  @Test
  public void shouldEditDocumentOnDatabase() {

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
      "Teste edicao", 
      list, 
      false, 
      "1cvb675h89l0f", 
      list.size());
    
    Update update = new Update();
    ListOfCardsDTO listOfCardsDTODocument = update.document("626548e5cc3b3f22f7c161f7", dto);
    
    assertEquals(listOfCardsDTODocument.getTitle(), "Teste edicao");
    assertEquals(listOfCardsDTODocument.getUserId(), "1cvb675h89l0f");

  }
}
