package com.example.hubaloleg.topfour.presentation.global;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.hubaloleg.topfour.presentation.di.component.AppComponent;
import com.example.hubaloleg.topfour.presentation.di.component.DaggerAppComponent;
import com.example.hubaloleg.topfour.presentation.di.module.app.AppModule;

import io.fabric.sdk.android.Fabric;

/**
 * Created by kostya on 10.07.17.
 */

public class TopFourApplication extends Application {
    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(TopFourApplication.this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
