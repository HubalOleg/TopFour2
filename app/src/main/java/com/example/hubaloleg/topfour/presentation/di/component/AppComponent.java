package com.example.hubaloleg.topfour.presentation.di.component;

import android.app.Application;
import android.content.Context;

import com.example.hubaloleg.topfour.presentation.di.module.ApplicationModule;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hubaloleg on 10.07.17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface AppComponent {
    void inject(TopFourApplication application);

    Context getContext();
}
