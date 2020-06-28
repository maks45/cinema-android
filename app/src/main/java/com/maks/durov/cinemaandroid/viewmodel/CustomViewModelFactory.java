package com.maks.durov.cinemaandroid.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.maks.durov.cinemaandroid.repository.MovieRepository;

@Singleton
public class CustomViewModelFactory implements ViewModelProvider.Factory {
    private final MovieRepository movieRepository;

    @Inject
    public CustomViewModelFactory(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(CinemaViewModel.class)) {
            return (T) new CinemaViewModel(movieRepository);
        }
        throw new IllegalArgumentException("ViewModel not found");
    }
}
