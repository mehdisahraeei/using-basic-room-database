package com.mahdi.roomdatabase.Data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.mahdi.roomdatabase.Data.entity.Contact;
import java.util.List;



@Dao
public interface ContactDAO {

    @Insert
    public void insertAll(List<Contact> contactList);


    @Query("SELECT * FROM Contact")
    public List<Contact> getAll();


}
