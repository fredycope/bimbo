package com.example.bimbodemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class Preferences {
    SharedPreferences sharedPref;
    @Inject
    Preferences(){

    }

    public void savePreference(Activity activity, String username){
         sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("user_name", username);
        editor.apply();
    }

    public String readPreference(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString("user_name", "");
    }





}
