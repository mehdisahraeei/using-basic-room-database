package com.mahdi.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.os.Bundle;

import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.Data.entity.Contact;
import com.mahdi.roomdatabase.databinding.ActivityMainBinding;
import com.mahdi.roomdatabase.model.ModelOne;
import com.mahdi.roomdatabase.viewmodel.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseNew databaseNew;
    private List<Contact> contactList;
    private List<Contact> getList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        databaseNew = Room.databaseBuilder(this, DatabaseNew.class, "contactDB").
                allowMainThreadQueries().build();
        Insert();



        getList = databaseNew.getContactDAO().getAll();
        binding.setMain(new MainView(new ModelOne(getList.get(1).getName(), getList.get(1).getAge())));
    }




    public void Insert() {
        contactList = new ArrayList<>();
        contactList.add(new Contact("Mahdi", 23));
        contactList.add(new Contact("Afshin", 23));
        contactList.add(new Contact("Parisa", 15));

        databaseNew.getContactDAO().insertAll(contactList);
    }


}