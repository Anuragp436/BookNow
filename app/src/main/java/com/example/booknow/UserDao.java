package com.example.booknow;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.booknow.MainData;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT* FROM users")
    LiveData<List<MainData>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertAll(MainData...user);

    @Query("SELECT * FROM users")
    List<MainData> getAllis();
}
