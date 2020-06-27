package com.maks.durov.cinemaandroid.di.module;

import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.db.CinemaDatabase;
import com.maks.durov.cinemaandroid.repository.CinemaRepository;
import com.maks.durov.cinemaandroid.viewmodel.CustomViewModelFactory;

@Module
public class RoomModule {
    private final CinemaDatabase cinemaDatabase;

    @Inject
    public RoomModule(Application application) {
        cinemaDatabase = Room.databaseBuilder(
                application,
                CinemaDatabase.class, "cinema_db")
                .build();
    }

    @Provides
    @Singleton
    public CinemaRepository provideCinemaRepository(MovieDao movieDao) {
        return new CinemaRepository(movieDao);
    }

    @Provides
    @Singleton
    public MovieDao provideMovieDao(CinemaDatabase cinemaDatabase) {
        return cinemaDatabase.movieDao();
    }

    @Provides
    @Singleton
    public CinemaDatabase provideCinemaDatabase(Application application) {
        return cinemaDatabase;
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory provideViewModelProviderFactory(
            CinemaRepository cinemaRepository) {
        return new CustomViewModelFactory(cinemaRepository);
    }
}
