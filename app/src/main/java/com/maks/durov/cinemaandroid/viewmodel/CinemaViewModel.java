package com.maks.durov.cinemaandroid.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import com.maks.durov.cinemaandroid.repository.CinemaRepository;
import com.maks.durov.cinemaandroid.model.Movie;
import java.util.List;

public class CinemaViewModel extends ViewModel {
    public CinemaRepository cinemaRepository;

    @Inject
    public CinemaViewModel(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }


    public void insert(Movie movie){
        cinemaRepository.insert(movie);
    }

    public LiveData<List<Movie>> getMovies(){
        return cinemaRepository.getMovies();
    }
}
