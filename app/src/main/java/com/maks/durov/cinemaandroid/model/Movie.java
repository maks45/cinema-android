package com.maks.durov.cinemaandroid.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;

@Data
@Entity(tableName = "movies")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String title;
    private String description;
}
