package com.maks.durov.cinemaandroid.ui;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.maks.durov.cinemaandroid.R;
import com.maks.durov.cinemaandroid.model.Movie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Movie movie  = new Movie();

        Log.d("TEST", "onCreate: "+ movie.getTitle());

    }
}
