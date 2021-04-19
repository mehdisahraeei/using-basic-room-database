package com.mahdi.roomdatabase.Data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity(tableName = "Contact")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Age")
    private int age;


    public Contact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
