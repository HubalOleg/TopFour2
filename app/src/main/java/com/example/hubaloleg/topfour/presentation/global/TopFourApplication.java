package com.example.hubaloleg.topfour.presentation.global;

import android.app.Application;

import com.example.hubaloleg.topfour.presentation.di.component.AppComponent;
import com.example.hubaloleg.topfour.presentation.di.component.DaggerAppComponent;
import com.example.hubaloleg.topfour.presentation.di.module.ApplicationModule;


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
                .applicationModule(new ApplicationModule(TopFourApplication.this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
