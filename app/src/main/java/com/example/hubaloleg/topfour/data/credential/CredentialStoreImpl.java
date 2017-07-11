package com.example.hubaloleg.topfour.data.credential;

import android.content.SharedPreferences;

/**
 * Created by kostya on 10.07.17.
 */

public class CredentialStoreImpl implements CredentialStore {

    private static final String KEY_TOKEN = "key_token";

    private final SharedPreferences mSharedPreferences;

    public CredentialStoreImpl(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;

    }

    @Override
    public void saveToken(String token) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_TOKEN, token);
        editor.apply();
    }

    @Override
    public String loadToken() {
        return mSharedPreferences.getString(KEY_TOKEN, "");
    }
}
