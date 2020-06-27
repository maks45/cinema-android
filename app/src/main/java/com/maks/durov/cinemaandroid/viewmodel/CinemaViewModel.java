package com.maks.durov.cinemaandroid.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.maks.durov.cinemaandroid.CinemaApplication;
import com.maks.durov.cinemaandroid.CinemaRepository;
import com.maks.durov.cinemaandroid.model.Movie;
import java.util.List;

public class CinemaViewModel extends AndroidViewModel {
    private final CinemaRepository cinemaRepository;
    private final LiveData<List<Movie>> movies;

    public CinemaViewModel(@NonNull Application application) {
        super(application);
        cinemaRepository = new CinemaRepository((CinemaApplication) application);
        movies = cinemaRepository.getMovies();
    }


    public void insert(Movie movie){
        cinemaRepository.insert(movie);
    }

    public LiveData<List<Movie>> getMovies(){
        return movies;
    }
}
