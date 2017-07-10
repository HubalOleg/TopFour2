package com.example.hubaloleg.topfour.data.security;

import android.content.SharedPreferences;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class SecurityManager implements ISecurityManager {

    private final SharedPreferences mSharedPreferences;

    private static final String PARAM_TOKEN = "PARAM_TOKEN";

    public SecurityManager(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public String loadUserToken() {
        return getString(PARAM_TOKEN);
    }

    @Override
    public void storeUserToken(String token) {
        setString(PARAM_TOKEN, token);
    }

    @Override
    public boolean isUserLoggedIn() {
        return false;
    }

    private void setString(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }

}
