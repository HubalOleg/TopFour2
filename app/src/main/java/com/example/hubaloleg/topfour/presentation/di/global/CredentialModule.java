package com.example.hubaloleg.topfour.presentation.di.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.credential.CredentialStoreImpl;
import com.example.hubaloleg.topfour.presentation.global.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kostya on 10.07.17.
 */

@Module
public class CredentialModule {

    @Provides
    @Singleton
    String providePreferenceName() {
        return Constants.PREFERENCE_NAME;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPref(Context context, String prefsName) {
        return context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    CredentialStore provideCredentialStore(SharedPreferences sharedPreferences) {
        return new CredentialStoreImpl(sharedPreferences);
    }
}
