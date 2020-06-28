package com.maks.durov.cinemaandroid.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import javax.inject.Inject;
import com.maks.durov.cinemaandroid.repository.MovieRepository;
import com.maks.durov.cinemaandroid.model.Movie;
import java.util.List;

public class CinemaViewModel extends ViewModel {
    public MovieRepository movieRepository;

    @Inject
    public CinemaViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void insert(Movie movie){
        movieRepository.insert(movie);
    }

    public LiveData<List<Movie>> getMovies(){
        return movieRepository.getMovies();
    }
}
