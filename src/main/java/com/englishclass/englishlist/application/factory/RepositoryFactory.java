package com.englishclass.englishlist.application.factory;

import com.englishclass.englishlist.adapters.output.DatabaseRepositoryImpl;
import com.englishclass.englishlist.application.useCase.FindListOfCardsOnDatabase;

public class RepositoryFactory {
  
  public FindListOfCardsOnDatabase buildDatabaseRepository() {
    return new FindListOfCardsOnDatabase(new DatabaseRepositoryImpl());
  }
}
