package com.maks.durov.cinemaandroid.ui;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.maks.durov.cinemaandroid.Application;
import com.maks.durov.cinemaandroid.CinemaRepository;
import com.maks.durov.cinemaandroid.R;
import com.maks.durov.cinemaandroid.model.Movie;
import com.maks.durov.cinemaandroid.viewmodel.CinemaViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CinemaViewModel cinemaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        cinemaViewModel = ViewModelProviders.of(this).get(CinemaViewModel.class);

        Movie movie = new Movie();
        movie.setTitle("test title");
        movie.setDescription("description");

        cinemaViewModel.insert(movie);

        cinemaViewModel.getMovies().observe(this, adapter::setMovies);
    }
}
