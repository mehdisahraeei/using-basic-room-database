package com.mahdi.roomdatabase.viewmodel;

import androidx.databinding.BaseObservable;

import com.mahdi.roomdatabase.model.InsertModel;

public class InsertViewModel extends BaseObservable {

    public String name;
    public int age;

    public InsertViewModel() {
    }

    public InsertViewModel(InsertModel model) {
        this.name = model.name;
        this.age = model.age;
    }

}
