package com.mahdi.roomdatabase.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.Data.entity.Contact;
import com.mahdi.roomdatabase.R;
import com.mahdi.roomdatabase.clicks.InsertClicks;
import com.mahdi.roomdatabase.databinding.ActivityInsertBinding;
import com.mahdi.roomdatabase.viewmodel.MainModel;
import java.util.ArrayList;
import java.util.List;



public class InsertActivity extends AppCompatActivity {

    private ActivityInsertBinding binding;
    private DatabaseNew database;
    private MainModel mainModel;
    private EditText editText1, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_insert);
        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);


        database = DatabaseNew.getDatabase(this);
        mainModel = new ViewModelProvider(this).get(MainModel.class);
        mainModel.getLiveData().setValue(database);


        binding.setInsertClick(new InsertClicks() {
            @Override
            public void ClickInsert(View view) {
                Add();
            }
        });


        Observer<DatabaseNew> observer = new Observer<DatabaseNew>() {
            @Override
            public void onChanged(DatabaseNew databaseNew) {
                //-------------------------------------------------
            }
        };

        mainModel.getLiveData().observe(this, observer);
    }




    private void Add() {
        List<Contact> list = new ArrayList<>();

        if (((editText1.getText().toString().isEmpty() & (editText2.getText().toString().isEmpty())))) {
            Toast.makeText(this, "Values are Wrong! please Enter Again.", Toast.LENGTH_SHORT).show();
        } else {
            list.add(new Contact(editText1.getText().toString(), Integer
                    .parseInt(editText2.getText().toString())));
            database.contactDAO().insertAll(list);
            Toast.makeText(InsertActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        }
    }




}