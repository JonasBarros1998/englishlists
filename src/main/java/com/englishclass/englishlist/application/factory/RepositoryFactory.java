package com.englishclass.englishlist.application.factory;

import com.englishclass.englishlist.adapters.output.DatabaseRepositoryImpl;
import com.englishclass.englishlist.application.useCase.FindListOfCardsOnDatabase;
import com.englishclass.englishlist.application.useCase.InsertEnglishListOnDatabase;
import com.englishclass.englishlist.application.useCase.UpdateEnglishListOnDatabase;

public class RepositoryFactory {
  
  public FindListOfCardsOnDatabase buildDatabaseRepository() {
    return new FindListOfCardsOnDatabase(new DatabaseRepositoryImpl());
  }

  public InsertEnglishListOnDatabase buildDatabaseRepositoryForInserNewEnglishList() {
    return new InsertEnglishListOnDatabase(new DatabaseRepositoryImpl());
  }

  public UpdateEnglishListOnDatabase buildDatabaseRepositoryForUpdateEnglishList() {
    return new UpdateEnglishListOnDatabase(new DatabaseRepositoryImpl());
  }

}
