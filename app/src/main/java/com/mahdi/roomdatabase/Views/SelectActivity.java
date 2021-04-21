package com.mahdi.roomdatabase.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.mahdi.roomdatabase.R;
import com.mahdi.roomdatabase.databinding.ActivitySelectBinding;

public class SelectActivity extends AppCompatActivity {

    private ActivitySelectBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select);
    }
}