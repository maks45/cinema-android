package com.maks.durov.cinemaandroid.di.component;

import android.app.Application;
import dagger.Component;
import javax.inject.Singleton;
import com.maks.durov.cinemaandroid.di.module.AppModule;
import com.maks.durov.cinemaandroid.di.module.RoomModule;
import com.maks.durov.cinemaandroid.ui.MainActivity;

@Component(modules = {AppModule.class, RoomModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity mainActivity);

    Application application();
}
