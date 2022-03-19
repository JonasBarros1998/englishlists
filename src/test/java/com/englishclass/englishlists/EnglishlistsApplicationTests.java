package com.englishclass.englishlists;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.englishclass.englishlists.application.model.List;

import org.junit.jupiter.api.Test;

class EnglishlistsApplicationTests {

	@Test
	public void shouldToInsertAnNewUserInAList() {
		List list = new List();
		list.insertCardInList("House", "In my house", "casa");
		assertEquals(1, list.getCards().size());
	}

}
