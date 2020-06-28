package com.maks.durov.cinemaandroid.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.maks.durov.cinemaandroid.dao.MovieDao;
import com.maks.durov.cinemaandroid.dao.TicketDao;
import com.maks.durov.cinemaandroid.dao.UserDao;
import com.maks.durov.cinemaandroid.model.Movie;
import com.maks.durov.cinemaandroid.model.Ticket;
import com.maks.durov.cinemaandroid.model.User;

@Database(entities = {Movie.class, Ticket.class, User.class}, version = 1)
public abstract class CinemaDatabase extends RoomDatabase {
    public abstract MovieDao movieDao();

    public abstract UserDao userDao();

    public abstract TicketDao ticketDao();
}
