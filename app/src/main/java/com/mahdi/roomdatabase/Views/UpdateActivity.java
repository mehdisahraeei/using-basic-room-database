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
import com.mahdi.roomdatabase.clicks.UpdateClicks;
import com.mahdi.roomdatabase.databinding.ActivityUpdateBinding;
import com.mahdi.roomdatabase.viewmodel.MainModel;



public class UpdateActivity extends AppCompatActivity {

    private ActivityUpdateBinding binding;
    private DatabaseNew database;
    private MainModel mainModel;
    private EditText editText1,editText2,editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update);

        editText1=findViewById(R.id.e1);
        editText2=findViewById(R.id.e2);
        editText3=findViewById(R.id.e3);


        database = Room.databaseBuilder(this, DatabaseNew.class, "db1").allowMainThreadQueries().build();
        mainModel = new ViewModelProvider(this).get(MainModel.class);
        mainModel.getLiveData().setValue(database);






        Observer<DatabaseNew> observer=new Observer<DatabaseNew>() {
            @Override
            public void onChanged(DatabaseNew databaseNew) {

                binding.setUpdateClick(new UpdateClicks() {
                    @Override
                    public void ClickUpdate(View view) {
                        if (((editText2.getText().toString().isEmpty() & (editText3.getText().toString().isEmpty()))))
                        {
                            Toast.makeText(UpdateActivity.this, "Values are Wrong! please Enter Again.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Contact contact=new Contact(editText2.getText().toString(),Integer.parseInt(editText3.getText().toString()));
                            contact.setID(Integer.parseInt(editText1.getText().toString()));
                            databaseNew.getContactDAO().Update(contact);
                            Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        };

        mainModel.getLiveData().observe(this,observer);



    }
}