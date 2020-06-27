package com.maks.durov.cinemaandroid;

import android.app.Application;
import lombok.Getter;
import com.maks.durov.cinemaandroid.di.component.AppComponent;
//import com.maks.durov.cinemaandroid.di.component.DaggerAppComponent;
import com.maks.durov.cinemaandroid.di.component.DaggerAppComponent;
import com.maks.durov.cinemaandroid.di.module.AppModule;
import com.maks.durov.cinemaandroid.di.module.RoomModule;

@Getter
public class CinemaApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .roomModule(new RoomModule(this))
                .build();
    }
}
