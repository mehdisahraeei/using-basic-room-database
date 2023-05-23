package com.mahdi.roomdatabase.viewmodel;

import androidx.databinding.BaseObservable;

import com.mahdi.roomdatabase.model.UpdateModel;

public class UpdateViewModel extends BaseObservable {

    public String name;
    public int age;

    public UpdateViewModel(UpdateModel model) {
        this.name = model.name;
        this.age = model.age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

