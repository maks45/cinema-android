package com.maks.durov.cinemaandroid.di.module;

import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.dao.TicketDao;
import com.maks.durov.cinemaandroid.dao.UserDao;
import com.maks.durov.cinemaandroid.db.CinemaDatabase;
import com.maks.durov.cinemaandroid.repository.MovieRepository;
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
    public MovieRepository provideCinemaRepository(MovieDao movieDao) {
        return new MovieRepository(movieDao);
    }

    @Provides
    @Singleton
    public MovieDao provideMovieDao(CinemaDatabase cinemaDatabase) {
        return cinemaDatabase.movieDao();
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(CinemaDatabase cinemaDatabase) {
        return cinemaDatabase.userDao();
    }

    @Provides
    @Singleton
    public TicketDao provideTicketDao(CinemaDatabase cinemaDatabase) {
        return cinemaDatabase.ticketDao();
    }

    @Provides
    @Singleton
    public CinemaDatabase provideCinemaDatabase(Application application) {
        return cinemaDatabase;
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory provideViewModelProviderFactory(
            MovieRepository movieRepository) {
        return new CustomViewModelFactory(movieRepository);
    }
}
