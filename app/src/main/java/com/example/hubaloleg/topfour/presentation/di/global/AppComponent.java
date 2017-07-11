package com.example.hubaloleg.topfour.presentation.di.global;

import android.content.Context;

import com.example.hubaloleg.topfour.data.local.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.api.ApiInterface;
import com.example.hubaloleg.topfour.presentation.di.global.ApplicationModule;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.authorization.AuthorizationActivity;
import com.example.hubaloleg.topfour.presentation.screens.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hubaloleg on 10.07.17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        CredentialModule.class,
        NetworkModule.class
})
public interface AppComponent {
    void inject(TopFourApplication application);

    void inject(SplashActivity splashActivity);

    void inject(AuthorizationActivity authorizationActivity);

    ApiInterface provideApiInterface();

    CredentialStore provideCredentialStore();

    Context getContext();
}
