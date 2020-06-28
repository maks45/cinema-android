package com.maks.durov.cinemaandroid.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
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
    //TODO don't forget! remove annotation and do something with one to many relation in this field
    @Ignore
    private List<Ticket> tickets;
}
