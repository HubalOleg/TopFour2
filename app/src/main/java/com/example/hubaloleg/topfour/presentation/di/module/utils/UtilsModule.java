package com.example.hubaloleg.topfour.presentation.di.module.utils;

import android.content.Context;
import android.content.SharedPreferences;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kostya on 10.07.17.
 */

@Module
public class UtilsModule {
    private static final String PREF_NAME = "APP_SHARED_PREF";

    @Provides
    @Singleton
    SharedPreferences provideSharedPref(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
