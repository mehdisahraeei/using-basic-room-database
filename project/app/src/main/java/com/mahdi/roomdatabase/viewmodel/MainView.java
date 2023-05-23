package com.mahdi.roomdatabase.viewmodel;

import com.mahdi.roomdatabase.model.ModelOne;

public class MainView {

    public String name;
    public int age;

    public MainView(ModelOne model) {
        name = model.name;
        age = model.age;
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
