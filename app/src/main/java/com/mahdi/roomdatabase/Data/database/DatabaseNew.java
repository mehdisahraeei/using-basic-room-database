package com.mahdi.roomdatabase.Data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.mahdi.roomdatabase.Data.dao.ContactDAO;
import com.mahdi.roomdatabase.Data.entity.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class DatabaseNew extends RoomDatabase {

    public abstract ContactDAO getContactDAO();

}
