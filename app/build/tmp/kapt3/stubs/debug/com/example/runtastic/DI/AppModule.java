package com.example.runtastic.DI;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/runtastic/DI/AppModule;", "", "()V", "provideRunDao", "Lcom/example/runtastic/db/RunDao;", "db", "Lcom/example/runtastic/db/RunningDatabase;", "provideRunningDatabase", "app", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class AppModule {
    public static final com.example.runtastic.DI.AppModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.runtastic.db.RunningDatabase provideRunningDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.runtastic.db.RunDao provideRunDao(@org.jetbrains.annotations.NotNull()
    com.example.runtastic.db.RunningDatabase db) {
        return null;
    }
    
    private AppModule() {
        super();
    }
}