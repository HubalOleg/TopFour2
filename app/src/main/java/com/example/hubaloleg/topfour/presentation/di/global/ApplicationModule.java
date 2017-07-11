package com.example.hubaloleg.topfour.presentation.di.global;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kostya on 10.07.17.
 */

@Module
public class ApplicationModule {
    private Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mContext;
    }
}

