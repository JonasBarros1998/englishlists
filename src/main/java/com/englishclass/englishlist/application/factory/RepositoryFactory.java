package com.englishclass.englishlist.application.factory;

import com.englishclass.englishlist.adapters.output.DatabaseRepositoryImpl;
import com.englishclass.englishlist.application.useCase.FindListOfCardsOnDatabase;
import com.englishclass.englishlist.application.useCase.InsertEnglishListOnDatabase;

public class RepositoryFactory {
  
  public FindListOfCardsOnDatabase buildDatabaseRepository() {
    return new FindListOfCardsOnDatabase(new DatabaseRepositoryImpl());
  }

  public InsertEnglishListOnDatabase buildDatabaseRepositoryForInserNewEnglishList() {
    return new InsertEnglishListOnDatabase(new DatabaseRepositoryImpl());
  }

}
