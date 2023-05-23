package com.mahdi.roomdatabase.Data.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.mahdi.roomdatabase.Data.entity.Contact;
import java.util.List;


@Dao
public interface ContactDAO {

    @Insert
    public void insertAll(List<Contact> contactList);


    @Delete
    public void Delete(Contact contact);

    @Update
    public void Update(Contact contact);


    @Query("SELECT * FROM Contact")
    public List<Contact> getAll();


    @Query("SELECT * FROM Contact WHERE Name LIKE :n")
    public List<Contact> getContactList(String n);


}
