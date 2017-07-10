package com.example.hubaloleg.topfour.data.security;

import android.content.SharedPreferences;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class SecurityManager implements ISecurityManager {

    private final SharedPreferences mSharedPreferences;

    public SecurityManager(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public String loadUserToken() {
        return null;
    }

    @Override
    public void storeUserToken(String token) {

    }

    @Override
    public boolean isUserLoggedIn() {
        return false;
    }
}
