package com.englishclass.englishlists.application.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnglishlistsApplicationTests {

	private ArrayList<Card> listOfCards;

	@BeforeEach
	public void inicializar() {
		this.listOfCards = new ArrayList<Card>();
		this.listOfCards.add(new Card("House", "In my house", "casa"));
		this.listOfCards.add(new Card("red", "color", "vermelho"));
	}

	@Test
	public void shouldToInsertAnNewUserInAList() {
		List list = new List("my list");

		for (Card card : listOfCards) {
			list.insertCardInList(card);
		}

		assertEquals(2, list.getCards().size());
	}

}
