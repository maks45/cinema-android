package com.maks.durov.cinemaandroid.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Data;
import java.util.List;

@Data
@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private Long id;
    private String login;
    private String email;

    private List<Ticket> tickets;
}
