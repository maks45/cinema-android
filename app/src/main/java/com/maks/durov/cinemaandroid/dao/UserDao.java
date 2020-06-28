package com.maks.durov.cinemaandroid.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.maks.durov.cinemaandroid.model.User;
import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(User user);

    @Update
    void update(User user);;

    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();
}
