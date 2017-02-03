package com.example.oleksandr.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksandr on 03.02.2017.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAsset;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context) {
        mAsset = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String[] soundsNames;
        try {
            soundsNames = mAsset.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found" + soundsNames.length + "sounds");
        }catch (IOException ioe){
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }
        for (String fileName : soundsNames){
            String assethPath = SOUNDS_FOLDER + "/" + fileName;
            Sound sound = new Sound(assethPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
