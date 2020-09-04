package com.example.runtastic.ui.viewmodels;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.runtastic.Repositories.MainRepository;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class StatisticsViewModel_AssistedFactory implements ViewModelAssistedFactory<StatisticsViewModel> {
  private final Provider<MainRepository> mainRepository;

  @Inject
  StatisticsViewModel_AssistedFactory(Provider<MainRepository> mainRepository) {
    this.mainRepository = mainRepository;
  }

  @Override
  @NonNull
  public StatisticsViewModel create(SavedStateHandle arg0) {
    return new StatisticsViewModel(mainRepository.get());
  }
}
