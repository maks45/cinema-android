package com.maks.durov.cinemaandroid.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.maks.durov.cinemaandroid.model.Ticket;
import java.util.List;

@Dao
public interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(Ticket ticket);

    @Update
    void update(Ticket ticket);

    @Query("SELECT * FROM tickets")
    LiveData<List<Ticket>> getAllTickets();
}
