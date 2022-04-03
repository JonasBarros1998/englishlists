package com.englishclass.englishlist.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.englishclass.englishlist.application.model.Card;
import com.englishclass.englishlist.application.model.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Cards {

	private ArrayList<Card> listOfCards;

	@BeforeEach
	public void inicializar() {
		this.listOfCards = new ArrayList<Card>();
		this.listOfCards.add(new Card("House", "In my house", "casa"));
		this.listOfCards.add(new Card("red", "color", "vermelho"));
	}

	@Test
	public void shouldToInsertANewUserInAList() {
		List list = new List();
		list.setTitle("my first list");

		for (Card card : listOfCards) {
			list.insertCardInList(card);
		}

		assertEquals(2, list.getCards().size());
	}

}
