package com.example.oleksandr.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
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
    private static final int MAX_SOUNDS = 5;

    private AssetManager mAsset;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context) {
        mAsset = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
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
            try {
                String assethPath = SOUNDS_FOLDER + "/" + fileName;
                Sound sound = new Sound(assethPath);
                load(sound);
                mSounds.add(sound);
            }catch (IOException ioe){
                Log.e(TAG,"Could not load sound" + fileName, ioe);
            }
        }
    }

    private void load(Sound sound)throws IOException{
        AssetFileDescriptor afd = mAsset.openFd(sound.getAssetsPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if (soundId == null){
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void relese(){
        mSoundPool.release();
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
