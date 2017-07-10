package com.example.hubaloleg.topfour.presentation.di.component;

import android.content.Context;

import com.example.hubaloleg.topfour.presentation.di.module.utils.UtilsModule;
import com.example.hubaloleg.topfour.presentation.di.module.app.AppModule;
import com.example.hubaloleg.topfour.presentation.di.module.network.NetworkModule;
import com.example.hubaloleg.topfour.presentation.screens.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hubaloleg on 10.07.17.
 */

@Singleton
@Component(modules =  {
        NetworkModule.class,
        AppModule.class,
        UtilsModule.class
})
public interface AppComponent {
    void inject(SplashActivity splashActivity);
}
