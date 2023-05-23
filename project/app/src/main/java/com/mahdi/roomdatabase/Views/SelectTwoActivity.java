package com.mahdi.roomdatabase.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.Data.entity.Contact;
import com.mahdi.roomdatabase.R;
import com.mahdi.roomdatabase.clicks.InsertTwoClicks;
import com.mahdi.roomdatabase.databinding.ActivitySelectTwoBinding;
import com.mahdi.roomdatabase.viewmodel.MainModel;
import java.util.List;

public class SelectTwoActivity extends AppCompatActivity {

    private ActivitySelectTwoBinding binding;
    private DatabaseNew databaseNew;
    private EditText editText;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_two);

        editText = findViewById(R.id.editTwo);
        imageView = findViewById(R.id.img_St);

        MainModel mainModel = new ViewModelProvider(this).get(MainModel.class);
        databaseNew = DatabaseNew.getDatabase(this);
        mainModel.getLiveData().setValue(databaseNew);


        Observer<DatabaseNew> observer = new Observer<DatabaseNew>() {
            @Override
            public void onChanged(DatabaseNew databaseNew) {

                binding.setSelectTwoClick(new InsertTwoClicks() {
                    @Override
                    public void ClickInsert(View view) {

                        try {
                            List<Contact> contacts=databaseNew.contactDAO().getAll();

                            imageView.setImageResource(contacts.get(Integer.parseInt(editText.getText().toString())).getImage());

                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                    }
                });

            }
        };
        mainModel.getLiveData().observe(this, observer);



    }
}