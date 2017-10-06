package edu.umsl.jackson.assignment2;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by christopherjackson on 2/8/17.
 */

public class Model extends MainActivity {

    public static final String RED = "RED";
    public static final String GREEN = "GREEN";
    public static final String YELLOW = "YELLOW";
    private String current_state;

    public Model() {
        current_state = "";
    }

    public String getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(String current_state) {
        this.current_state = current_state;
    }

    public String change_state() {

        switch(current_state) {

            case "RED": current_state = GREEN;
                        break;

            case "GREEN": current_state = YELLOW;
                        break;

            case "YELLOW": current_state = RED;
                        break;
            default:
                current_state = GREEN;
        }
        return current_state;
    }

}



