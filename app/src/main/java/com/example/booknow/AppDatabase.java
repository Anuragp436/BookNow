package com.example.booknow;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.booknow.MainData;
import com.example.booknow.UserDao;

@Database(entities = {MainData.class},version=5)
public abstract class AppDatabase extends RoomDatabase {

private static AppDatabase INSTANCE;
public synchronized static AppDatabase getDBInstance(Context context)
{
    if(INSTANCE==null)
    {
        INSTANCE= Room.databaseBuilder(context,AppDatabase.class,"data")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
    return INSTANCE;
}
    public abstract UserDao userDao();
}
