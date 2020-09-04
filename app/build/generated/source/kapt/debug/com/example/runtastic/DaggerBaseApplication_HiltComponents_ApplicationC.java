package com.example.runtastic;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.runtastic.DI.AppModule;
import com.example.runtastic.DI.AppModule_ProvideRunDaoFactory;
import com.example.runtastic.DI.AppModule_ProvideRunningDatabaseFactory;
import com.example.runtastic.Repositories.MainRepository;
import com.example.runtastic.db.RunDao;
import com.example.runtastic.db.RunningDatabase;
import com.example.runtastic.ui.MainActivity;
import com.example.runtastic.ui.fragments.RunFragment;
import com.example.runtastic.ui.fragments.StatisticsFragment;
import com.example.runtastic.ui.fragments.TrackingFragment;
import com.example.runtastic.ui.viewmodels.MainViewModel_AssistedFactory;
import com.example.runtastic.ui.viewmodels.MainViewModel_AssistedFactory_Factory;
import com.example.runtastic.ui.viewmodels.StatisticsViewModel_AssistedFactory;
import com.example.runtastic.ui.viewmodels.StatisticsViewModel_AssistedFactory_Factory;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
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
public final class DaggerBaseApplication_HiltComponents_ApplicationC extends BaseApplication_HiltComponents.ApplicationC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object runningDatabase = new MemoizedSentinel();

  private volatile Object runDao = new MemoizedSentinel();

  private DaggerBaseApplication_HiltComponents_ApplicationC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private RunningDatabase getRunningDatabase() {
    Object local = runningDatabase;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = runningDatabase;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideRunningDatabaseFactory.provideRunningDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          runningDatabase = DoubleCheck.reentrantCheck(runningDatabase, local);
        }
      }
    }
    return (RunningDatabase) local;
  }

  private RunDao getRunDao() {
    Object local = runDao;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = runDao;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideRunDaoFactory.provideRunDao(getRunningDatabase());
          runDao = DoubleCheck.reentrantCheck(runDao, local);
        }
      }
    }
    return (RunDao) local;
  }

  @Override
  public void injectBaseApplication(BaseApplication baseApplication) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public BaseApplication_HiltComponents.ApplicationC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerBaseApplication_HiltComponents_ApplicationC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements BaseApplication_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public BaseApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends BaseApplication_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements BaseApplication_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public BaseApplication_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends BaseApplication_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<MainRepository> mainRepositoryProvider;

      private volatile Provider<MainViewModel_AssistedFactory> mainViewModel_AssistedFactoryProvider;

      private volatile Provider<StatisticsViewModel_AssistedFactory> statisticsViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private MainRepository getMainRepository() {
        return new MainRepository(DaggerBaseApplication_HiltComponents_ApplicationC.this.getRunDao());
      }

      private Provider<MainRepository> getMainRepositoryProvider() {
        Object local = mainRepositoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(1);
          mainRepositoryProvider = (Provider<MainRepository>) local;
        }
        return (Provider<MainRepository>) local;
      }

      private MainViewModel_AssistedFactory getMainViewModel_AssistedFactory() {
        return MainViewModel_AssistedFactory_Factory.newInstance(getMainRepositoryProvider());
      }

      private Provider<MainViewModel_AssistedFactory> getMainViewModel_AssistedFactoryProvider() {
        Object local = mainViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          mainViewModel_AssistedFactoryProvider = (Provider<MainViewModel_AssistedFactory>) local;
        }
        return (Provider<MainViewModel_AssistedFactory>) local;
      }

      private StatisticsViewModel_AssistedFactory getStatisticsViewModel_AssistedFactory() {
        return StatisticsViewModel_AssistedFactory_Factory.newInstance(getMainRepositoryProvider());
      }

      private Provider<StatisticsViewModel_AssistedFactory> getStatisticsViewModel_AssistedFactoryProvider(
          ) {
        Object local = statisticsViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(2);
          statisticsViewModel_AssistedFactoryProvider = (Provider<StatisticsViewModel_AssistedFactory>) local;
        }
        return (Provider<StatisticsViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> getMapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return MapBuilder.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>newMapBuilder(2).put("com.example.runtastic.ui.viewmodels.MainViewModel", (Provider) getMainViewModel_AssistedFactoryProvider()).put("com.example.runtastic.ui.viewmodels.StatisticsViewModel", (Provider) getStatisticsViewModel_AssistedFactoryProvider()).build();
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerBaseApplication_HiltComponents_ApplicationC.this.applicationContextModule), getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private final class FragmentCBuilder implements BaseApplication_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public BaseApplication_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends BaseApplication_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerBaseApplication_HiltComponents_ApplicationC.this.applicationContextModule), ActivityCImpl.this.getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public void injectRunFragment(RunFragment runFragment) {
        }

        @Override
        public void injectStatisticsFragment(StatisticsFragment statisticsFragment) {
        }

        @Override
        public void injectTrackingFragment(TrackingFragment trackingFragment) {
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements BaseApplication_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public BaseApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends BaseApplication_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements BaseApplication_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public BaseApplication_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends BaseApplication_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.example.runtastic.ui.viewmodels.MainViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getMainViewModel_AssistedFactory();

            case 1: // com.example.runtastic.Repositories.MainRepository 
            return (T) ActivityCImpl.this.getMainRepository();

            case 2: // com.example.runtastic.ui.viewmodels.StatisticsViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getStatisticsViewModel_AssistedFactory();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements BaseApplication_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends BaseApplication_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }
}
