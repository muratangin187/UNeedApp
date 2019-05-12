package com.example.uneed.structures;

import android.app.Application;

public class GlobalData extends Application {

    private int user_id;

    public int getVariable() {
        return user_id;
    }

    public void setVariable(int user_id) {
        this.user_id = user_id;
    }
}