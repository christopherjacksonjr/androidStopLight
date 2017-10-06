package edu.umsl.jackson.assignment2;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * Created by christopherjackson on 2/9/17.
 */

public class right_fragment extends Fragment {

    private ImageView red_light;
    private ImageView green_light;
    private ImageView yellow_light;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_fragment, container, false);
        red_light = (ImageView) view.findViewById(R.id.red_light);
        red_light.setVisibility(View.VISIBLE);
        green_light = (ImageView) view.findViewById(R.id.green_light);
        yellow_light = (ImageView) view.findViewById(R.id.yellow_light);
        return view;
    }



    public void change_light(String new_state) {
        switch (new_state) {
            case Model.RED:
                    red_light.setVisibility(View.VISIBLE);
                    green_light.setVisibility(View.INVISIBLE);
                    yellow_light.setVisibility(View.INVISIBLE);
                    break;
            case Model.GREEN:
                    red_light.setVisibility(View.INVISIBLE);
                    green_light.setVisibility(View.VISIBLE);
                    yellow_light.setVisibility(View.INVISIBLE);
                    break;
            case Model.YELLOW:
                    red_light.setVisibility(View.INVISIBLE);
                    green_light.setVisibility(View.INVISIBLE);
                    yellow_light.setVisibility(View.VISIBLE);
                    break;
        }
    }
}
