package com.maks.durov.cinemaandroid.di.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Module
@RequiredArgsConstructor
public class AppModule {
    private final Application application;

    @Provides
    @Singleton
    public Application provideContext() {
        return application;
    }
}
