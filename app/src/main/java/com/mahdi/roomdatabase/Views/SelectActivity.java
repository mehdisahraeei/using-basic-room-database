package com.mahdi.roomdatabase.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.TextView;
import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.Data.entity.Contact;
import com.mahdi.roomdatabase.R;
import com.mahdi.roomdatabase.databinding.ActivitySelectBinding;
import com.mahdi.roomdatabase.viewmodel.MainModel;

import java.util.List;

public class SelectActivity extends AppCompatActivity {

    private ActivitySelectBinding binding;
    private DatabaseNew database;
    private MainModel mainModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select);


        textView = findViewById(R.id.textselect);
        database = DatabaseNew.getDatabase(this);
        mainModel = new ViewModelProvider(this).get(MainModel.class);
        mainModel.getLiveData().setValue(database);




        Observer<DatabaseNew> observer = new Observer<DatabaseNew>() {
            @Override
            public void onChanged(DatabaseNew databaseNew) {

                List<Contact> contacts = databaseNew.contactDAO().getAll();
                try {
                    for (int i = 0; i < contacts.size(); i++) {
                        textView.append(contacts.get(i).getID() + "      name: " + contacts.get(i).getName()
                                + "      age: " + contacts.get(i).getAge() +"\n");
                    }
                } catch (Exception e) {
                    e.getStackTrace();
                }

            }
        };
        mainModel.getLiveData().observe(this, observer);




    }
}