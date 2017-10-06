package edu.umsl.jackson.assignment2;



import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static edu.umsl.jackson.assignment2.R.id.button_fragment;

public class MainActivity extends AppCompatActivity implements left_fragment.LightChangeListener, headless_fragment.SequenceListener{

    private static final String left_fragment_tag = "left_fragment";
    private left_fragment mleft_fragment;
    private right_fragment traffic;
    private Model model;
    private headless_fragment mheadless_fragment;
    private static final String HEADLESS_FRAG_TAG = "headless_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        model = new Model();

        traffic = (right_fragment) getFragmentManager().findFragmentById(R.id.traffic_fragment);

        if(savedInstanceState != null){

            String state = savedInstanceState.getString("state");

            if(state != null && !state.equals("")){
                model.setCurrent_state(state);
                traffic.change_light(state);
            }
        }

        FragmentManager manager = getSupportFragmentManager();
        mheadless_fragment = (headless_fragment) manager.findFragmentByTag(HEADLESS_FRAG_TAG);
        if (mheadless_fragment == null) {
            mheadless_fragment = new headless_fragment();
            manager.beginTransaction()
                    .add(mheadless_fragment, HEADLESS_FRAG_TAG)
                    .commit();
        }
        mheadless_fragment.setSequenceListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String current_state = model.getCurrent_state();

        outState.putString("state", current_state);
    }

    @Override
    public void start() {
        mheadless_fragment.startSequence();
    }

    @Override
    public void stop() {
        mheadless_fragment.stopSequence();
        model.setCurrent_state(Model.RED);
        traffic.change_light(Model.RED);
    }

    @Override
    public String sequenceWasTriggered() {
        String new_state = model.change_state();
        traffic.change_light(new_state);

        return new_state;
    }
}
