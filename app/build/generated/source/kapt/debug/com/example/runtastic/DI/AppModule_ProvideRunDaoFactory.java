package com.example.runtastic.DI;

import com.example.runtastic.db.RunDao;
import com.example.runtastic.db.RunningDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideRunDaoFactory implements Factory<RunDao> {
  private final Provider<RunningDatabase> dbProvider;

  public AppModule_ProvideRunDaoFactory(Provider<RunningDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public RunDao get() {
    return provideRunDao(dbProvider.get());
  }

  public static AppModule_ProvideRunDaoFactory create(Provider<RunningDatabase> dbProvider) {
    return new AppModule_ProvideRunDaoFactory(dbProvider);
  }

  public static RunDao provideRunDao(RunningDatabase db) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideRunDao(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
