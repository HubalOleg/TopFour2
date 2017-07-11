package com.example.hubaloleg.topfour.presentation.di.component;

import com.example.hubaloleg.topfour.presentation.di.module.CredentialModule;
import com.example.hubaloleg.topfour.presentation.di.scopes.PerActivity;
import com.example.hubaloleg.topfour.presentation.screens.authorization.AuthorizationActivity;
import com.example.hubaloleg.topfour.presentation.screens.splash.SplashActivity;

import dagger.Component;

/**
 * Created by hubal on 7/10/2017.
 */

@PerActivity
@Component(
        dependencies = AppComponent.class,
        modules = CredentialModule.class)
public interface CredentialComponent {

    void inject(SplashActivity splashActivity);

    void inject(AuthorizationActivity authorizationActivity);
}
