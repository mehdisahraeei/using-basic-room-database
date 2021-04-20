package com.mahdi.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.clicks.ClickListener;
import com.mahdi.roomdatabase.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseNew databaseNew;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


//        databaseNew = Room.databaseBuilder(this, DatabaseNew.class, "contactDB").
//                allowMainThreadQueries().build();


        binding.setMainClick(new ClickListener() {
            @Override
            public void InsertClick(View view) {
            }
        });


    }
}