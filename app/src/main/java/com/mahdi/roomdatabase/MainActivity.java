package com.mahdi.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.mahdi.roomdatabase.databinding.ActivityMainBinding;
import com.mahdi.roomdatabase.model.ModelOne;
import com.mahdi.roomdatabase.viewmodel.MainView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.setMain(new MainView(new ModelOne("Mahdi",23)));

    }
}