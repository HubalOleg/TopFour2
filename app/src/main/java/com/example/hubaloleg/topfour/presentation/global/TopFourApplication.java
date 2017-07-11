package com.example.hubaloleg.topfour.presentation.global;

import android.app.Application;

import com.example.hubaloleg.topfour.presentation.di.global.AppComponent;
import com.example.hubaloleg.topfour.presentation.di.global.ApplicationModule;
import com.example.hubaloleg.topfour.presentation.di.global.DaggerAppComponent;


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
