package com.example.hubaloleg.topfour.presentation.di.global;

import android.content.Context;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;
import com.example.hubaloleg.topfour.presentation.di.qualifier.SchedulerUI;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.authorization.AuthorizationActivity;
import com.example.hubaloleg.topfour.presentation.screens.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Scheduler;

/**
 * Created by hubaloleg on 10.07.17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        CredentialModule.class,
        NetworkModule.class,
        SchedulerModule.class
})
public interface AppComponent {
    void inject(TopFourApplication application);

    void inject(SplashActivity splashActivity);

    void inject(AuthorizationActivity authorizationActivity);

    ApiInterface provideApiInterface();

    CredentialStore provideCredentialStore();

    @ApiVersion
    String provideApiVersion();

    Context provideAppContext();

    @SchedulerUI
    Scheduler provideSchedulerUI();
}
