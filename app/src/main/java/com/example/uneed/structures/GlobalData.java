package com.example.uneed.structures;

import android.app.Application;

/**
 * @author fistikci_sahap
 * @version 1.0
 */
public class GlobalData extends Application {

    private int user_id;
    
    /**
     * @return int user_id
     */
    public int getVariable() {
        return user_id;
    }

    /**
     * Sets user_id to parameter user_id
     * @param user_id
     */
    public void setVariable(int user_id) {
        this.user_id = user_id;
    }
}