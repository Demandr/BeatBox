package com.example.oleksandr.beatbox;


import android.support.v4.app.Fragment;
//import android.app.Fragment;

public class BeatBoxActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
