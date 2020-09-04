package com.example.runtastic.DI;

import android.content.Context;
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
public final class AppModule_ProvideRunningDatabaseFactory implements Factory<RunningDatabase> {
  private final Provider<Context> appProvider;

  public AppModule_ProvideRunningDatabaseFactory(Provider<Context> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public RunningDatabase get() {
    return provideRunningDatabase(appProvider.get());
  }

  public static AppModule_ProvideRunningDatabaseFactory create(Provider<Context> appProvider) {
    return new AppModule_ProvideRunningDatabaseFactory(appProvider);
  }

  public static RunningDatabase provideRunningDatabase(Context app) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideRunningDatabase(app), "Cannot return null from a non-@Nullable @Provides method");
  }
}
