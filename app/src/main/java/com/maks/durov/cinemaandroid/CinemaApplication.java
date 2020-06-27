package com.maks.durov.cinemaandroid;

import android.app.Application;
import lombok.Getter;

@Getter
public class CinemaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       // ApplicationComponent appComponent = DaggerApplicationComponent.create();
    }
}
