package com.englishclass.englishlist.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.englishclass.englishlist.application.model.Card;
import com.englishclass.englishlist.application.model.ListOfCards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListOfCardsTest {

	private ArrayList<Card> listOfCards;

	@BeforeEach
	public void inicializar() {
		this.listOfCards = new ArrayList<Card>();
		this.listOfCards.add(new Card("House", "In my house", "casa"));
		this.listOfCards.add(new Card("red", "color", "vermelho"));
	}

	@Test
	public void shouldToInsertANewCardOnList() {
		ListOfCards list = new ListOfCards();
		list.setTitle("My list");

		for (Card card : listOfCards) {
			list.insertCardInList(card);
		}

		assertEquals(2, list.getCards().size());
		assertEquals("My list", list.getTitle());
	}

}
