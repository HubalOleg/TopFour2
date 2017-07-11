package com.example.hubaloleg.topfour.presentation.di.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.credential.CredentialStoreImpl;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;
import com.example.hubaloleg.topfour.presentation.di.qualifier.PreferenceName;
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

    private final String mApiVersion;

    public CredentialModule(String apiVersion) {
        mApiVersion = apiVersion;
    }

    @Provides
    @ApiVersion
    String provideApiVersion() {
        return mApiVersion;
    }

    @Provides
    @PreferenceName
    String providePreferenceName() {
        return Constants.PREFERENCE_NAME;
    }

    @Provides
    SharedPreferences provideSharedPref(Context context, @PreferenceName String prefsName) {
        return context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    @Provides
    CredentialStore provideCredentialStore(SharedPreferences sharedPreferences) {
        return new CredentialStoreImpl(sharedPreferences);
    }
}
