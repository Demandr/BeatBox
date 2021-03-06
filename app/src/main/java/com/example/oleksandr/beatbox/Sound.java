package com.example.oleksandr.beatbox;

/**
 * Created by Oleksandr on 03.02.2017.
 */

public class Sound {
    private String mAssetsPath;
    private String mName;
    private Integer mSoundId;


    public Sound(String assetsPath){
        mAssetsPath = assetsPath;
        String[] componets = assetsPath.split("/");
        String fileName = componets[componets.length - 1];
        mName = fileName.replace(".wav", "");
    }

    public String getAssetsPath() {
        return mAssetsPath;
    }

    public String getName() {
        return mName;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
