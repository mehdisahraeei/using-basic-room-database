package com.mahdi.roomdatabase.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import com.mahdi.roomdatabase.Data.database.DatabaseNew;
import com.mahdi.roomdatabase.Data.entity.Contact;
import com.mahdi.roomdatabase.R;
import com.mahdi.roomdatabase.databinding.ActivitySearchBinding;
import com.mahdi.roomdatabase.viewmodel.MainModel;
import java.util.List;


public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    private MainModel mainModel;
    private DatabaseNew databaseNew;
    private SearchView searchView;
    private ListView listView;
    private List<Contact> contacts;
    private ArrayAdapter<Contact> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.list1);


        databaseNew = DatabaseNew.getDatabase(this);
        mainModel = new ViewModelProvider(this).get(MainModel.class);
        mainModel.getLiveData().setValue(databaseNew);





        Observer<DatabaseNew> observer = new Observer<DatabaseNew>() {
            @Override
            public void onChanged(DatabaseNew databaseNew) {


                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        getDatabasefromDb(query);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        getDatabasefromDb(newText);
                        return true;
                    }
                });


            }
        };
        mainModel.getLiveData().observe(this, observer);
    }





    private void getDatabasefromDb(String searchText) {
        searchText = "%" + searchText + "%";
        contacts=databaseNew.getDatabaseInfo(SearchActivity.this, searchText);

        arrayAdapter = new ArrayAdapter(SearchActivity.this, android.R.layout.
                simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);
    }


}