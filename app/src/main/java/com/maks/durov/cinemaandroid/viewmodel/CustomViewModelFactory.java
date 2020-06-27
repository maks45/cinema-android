package com.maks.durov.cinemaandroid.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.maks.durov.cinemaandroid.repository.CinemaRepository;

@Singleton
public class CustomViewModelFactory implements ViewModelProvider.Factory {
    private final CinemaRepository cinemaRepository;

    @Inject
    public CustomViewModelFactory(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(CinemaViewModel.class)) {
            return (T) new CinemaViewModel(cinemaRepository);
        }
        throw new IllegalArgumentException("ViewModel not found");
    }
}
