package com.mahdi.roomdatabase.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.Data.entity.Contact;
import com.mahdi.roomdatabase.R;
import com.mahdi.roomdatabase.clicks.RemoveClicks;
import com.mahdi.roomdatabase.databinding.ActivityRemoveBinding;
import com.mahdi.roomdatabase.viewmodel.MainModel;



public class RemoveActivity extends AppCompatActivity {

    private ActivityRemoveBinding binding;
    private DatabaseNew database;
    private MainModel mainModel;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_remove);

        editText = findViewById(R.id.tR);

        database = Room.databaseBuilder(this, DatabaseNew.class, "db1").allowMainThreadQueries().build();
        mainModel = new ViewModelProvider(this).get(MainModel.class);
        mainModel.getLiveData().setValue(database);


        Observer<DatabaseNew> observer = new Observer<DatabaseNew>() {
            @Override
            public void onChanged(DatabaseNew databaseNew) {


                binding.setRemoveClick(new RemoveClicks() {
                    @Override
                    public void ClickRemove(View view) {
                        if (editText.getText().toString().isEmpty()) {
                            Toast.makeText(RemoveActivity.this, "Values are Wrong! please Enter Again.", Toast.LENGTH_SHORT).show();
                        } else {
                            Contact contact = new Contact();
                            contact.setID(Integer.parseInt(editText.getText().toString()));
                            databaseNew.getContactDAO().Delete(contact);
                            Toast.makeText(RemoveActivity.this, "Removed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        };
        mainModel.getLiveData().observe(this, observer);


    }
}