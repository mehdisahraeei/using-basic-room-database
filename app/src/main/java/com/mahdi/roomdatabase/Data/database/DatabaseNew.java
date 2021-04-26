package com.mahdi.roomdatabase.Data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.mahdi.roomdatabase.Data.dao.ContactDAO;
import com.mahdi.roomdatabase.Data.entity.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class DatabaseNew extends RoomDatabase {

    private static DatabaseNew database;

    public abstract ContactDAO contactDAO();

    public synchronized static DatabaseNew getDatabase(Context context)
    {
        if (database==null)
        {
            database= Room.databaseBuilder(context.getApplicationContext(),DatabaseNew.class,"db1")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

}
