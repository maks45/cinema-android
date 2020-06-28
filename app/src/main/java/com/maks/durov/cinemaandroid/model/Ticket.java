package com.maks.durov.cinemaandroid.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import lombok.Data;

@Data
@Entity(tableName = "tickets")
public class Ticket {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ticket_id")
    private Long id;
    //TODO don't forget! remove annotation and do something with many to one relation
    @Ignore
    private MovieSession movieSession;
}
