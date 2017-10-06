package edu.umsl.jackson.assignment2;

//import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by christopherjackson on 2/17/17.
 */

public class headless_fragment extends Fragment {

    private Handler mHandler;
    SequenceListener mListener;

    interface SequenceListener {
        String sequenceWasTriggered();
    }
    void setSequenceListener(SequenceListener newListener) {
        this.mListener = newListener;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    void startSequence() {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
            mHandler.post(mRunnable);
        }
    }
    void stopSequence() {
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
            mHandler = null;
        }
    }
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            String color = null;
            if (mListener != null) {
                color = mListener.sequenceWasTriggered();
            }

            switch (color) {
                case Model.RED:
                    mHandler.postDelayed(mRunnable, 5000);
                    break;

                case Model.GREEN:
                    mHandler.postDelayed(mRunnable, 3000);
                    break;

                case Model.YELLOW:
                    mHandler.postDelayed(mRunnable, 2000);
                    break;
            }
        }
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "DESTROY Fragment");
    }
}
