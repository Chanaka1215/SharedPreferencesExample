package com.example.chanakafernando.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;

import static com.example.chanakafernando.sharedpreferencesexample.R.string.app_name;

/**
 * Created by Chanaka Fernando on 10/6/2017.
 */

public class PreferenceManager {

//    private static final String PREF_NAME = ;
//    private static final String UPDATE = "update";

    private static PreferenceManager sInstance;
    private final SharedPreferences mSharedPreferences;

    private PreferenceManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(context.getString(R.string.internal_key), Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferenceManager(context);
        }
    }

    public static synchronized PreferenceManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PreferenceManager.class.getSimpleName() + " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setUpdate(String key,String value) {
        mSharedPreferences.edit()
                .putString(key, value)
                .apply();
    }

    public String getUpdate(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public void remove(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    public boolean clear() {
        return mSharedPreferences.edit().clear().commit();
    }
}
