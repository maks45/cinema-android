package com.maks.durov.cinemaandroid.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import javax.inject.Inject;
import com.maks.durov.cinemaandroid.CinemaApplication;
import com.maks.durov.cinemaandroid.R;
import com.maks.durov.cinemaandroid.model.Movie;
import com.maks.durov.cinemaandroid.viewmodel.CinemaViewModel;

public class MainActivity extends AppCompatActivity {
    @Inject
    public CinemaViewModel cinemaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((CinemaApplication) getApplication()).getAppComponent().inject(this);

        RecyclerView recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        Movie movie = new Movie();
        movie.setTitle("test title");
        movie.setDescription("description");

        cinemaViewModel.insert(movie);

        cinemaViewModel.getMovies().observe(this, adapter::setMovies);
    }
}
