package com.example.hubaloleg.topfour.presentation.di.module;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.hubaloleg.topfour.data.local.prefs.CredentialStore;
import com.example.hubaloleg.topfour.data.local.prefs.CredentialStoreImpl;
import com.example.hubaloleg.topfour.presentation.di.qualifier.PreferenceName;
import com.example.hubaloleg.topfour.presentation.di.scopes.PerActivity;
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
    @PerActivity
    @PreferenceName
    String providePreferenceName() {
        return Constants.PREFERENCE_NAME;
    }

    @Provides
    @PerActivity
    SharedPreferences provideSharedPref(Context context, @PreferenceName String prefsName) {
        return context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    @Provides
    @PerActivity
    CredentialStore provideCredentialStore(SharedPreferences sharedPreferences) {
        return new CredentialStoreImpl(sharedPreferences);
    }


}
