package edu.umsl.jackson.assignment2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.widget.ImageView;

/**
 * Created by christopherjackson on 2/9/17.
 */

public class left_fragment extends Fragment {

    LightChangeListener lightChangeListener;
    Button start_button;
    Button stop_button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment, container, false);

        start_button = (Button) view.findViewById(R.id.start);
        stop_button = (Button) view.findViewById(R.id.stop);

        start_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                lightChangeListener.start();
            }
        });

        stop_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                lightChangeListener.stop();
            }
        });
        return view;
    }


    public interface LightChangeListener {
        void start();
        void stop();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            lightChangeListener = (LightChangeListener) activity;

        } catch (Exception e) {}
    }
}