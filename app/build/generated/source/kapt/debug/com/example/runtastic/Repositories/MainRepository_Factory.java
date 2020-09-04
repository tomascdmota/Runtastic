package com.example.runtastic.Repositories;

import com.example.runtastic.db.RunDao;
import dagger.internal.Factory;
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
public final class MainRepository_Factory implements Factory<MainRepository> {
  private final Provider<RunDao> runDaoProvider;

  public MainRepository_Factory(Provider<RunDao> runDaoProvider) {
    this.runDaoProvider = runDaoProvider;
  }

  @Override
  public MainRepository get() {
    return newInstance(runDaoProvider.get());
  }

  public static MainRepository_Factory create(Provider<RunDao> runDaoProvider) {
    return new MainRepository_Factory(runDaoProvider);
  }

  public static MainRepository newInstance(RunDao runDao) {
    return new MainRepository(runDao);
  }
}
