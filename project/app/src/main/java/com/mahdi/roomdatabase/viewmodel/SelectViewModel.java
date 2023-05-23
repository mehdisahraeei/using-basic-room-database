package com.mahdi.roomdatabase.viewmodel;

import androidx.databinding.BaseObservable;

import com.mahdi.roomdatabase.model.SelectModel;

public class SelectViewModel extends BaseObservable {

    public String text;

    public SelectViewModel(SelectModel model) {
        this.text = model.text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
