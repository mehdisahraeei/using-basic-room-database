package com.mahdi.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.Views.InsertActivity;
import com.mahdi.roomdatabase.Views.RemoveActivity;
import com.mahdi.roomdatabase.Views.SelectActivity;
import com.mahdi.roomdatabase.Views.UpdateActivity;
import com.mahdi.roomdatabase.clicks.ClickListener;
import com.mahdi.roomdatabase.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



        binding.setMainClick(new ClickListener() {
            @Override
            public void InsertClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }

            @Override
            public void RemoveClick(View view) {
                startActivity(new Intent(MainActivity.this, RemoveActivity.class));
            }

            @Override
            public void SelectClick(View view) {
                startActivity(new Intent(MainActivity.this, SelectActivity.class));
            }

            @Override
            public void UpdateClick(View view) {
                startActivity(new Intent(MainActivity.this, UpdateActivity.class));
            }
        });


    }
}