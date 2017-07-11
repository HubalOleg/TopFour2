package com.example.hubaloleg.topfour.presentation.di.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hubaloleg.topfour.data.local.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.local.credential.CredentialStoreImpl;
import com.example.hubaloleg.topfour.presentation.global.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kostya on 10.07.17.
 */

@Module
@Singleton
public class CredentialModule {

    @Provides
    String providePreferenceName() {
        return Constants.PREFERENCE_NAME;
    }

    @Provides
    SharedPreferences provideSharedPref(Context context, String prefsName) {
        return context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    @Provides
    CredentialStore provideCredentialStore(SharedPreferences sharedPreferences) {
        return new CredentialStoreImpl(sharedPreferences);
    }
}
