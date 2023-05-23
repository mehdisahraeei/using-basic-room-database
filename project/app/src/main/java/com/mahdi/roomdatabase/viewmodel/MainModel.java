package com.mahdi.roomdatabase.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mahdi.roomdatabase.Data.database.DatabaseNew;

public class MainModel extends ViewModel {

    private MutableLiveData<DatabaseNew> liveData;

    public MutableLiveData<DatabaseNew> getLiveData()
    {
        if (liveData==null)
        {
            liveData=new MutableLiveData<>();
        }
        return liveData;
    }




}
