package com.example.hubaloleg.topfour.presentation.global;

import android.app.Application;

import com.example.hubaloleg.topfour.data.cache.db.VenueDB;
import com.example.hubaloleg.topfour.presentation.di.global.AppComponent;
import com.example.hubaloleg.topfour.presentation.di.global.ApplicationModule;
import com.example.hubaloleg.topfour.presentation.di.global.CredentialModule;
import com.example.hubaloleg.topfour.presentation.di.global.DaggerAppComponent;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by kostya on 10.07.17.
 */

public class TopFourApplication extends Application {
    private static final String API_VERSION_DATE_FORMAT = "yyyyMMdd";

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
        FlowManager.init(TopFourApplication.this);
        String apiVersion = getApiVersion();
        mAppComponent = DaggerAppComponent
                .builder()
                .applicationModule(new ApplicationModule(TopFourApplication.this))
                .credentialModule(new CredentialModule(apiVersion))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    private String getApiVersion() {
        SimpleDateFormat apiVersionDateFormat = new SimpleDateFormat(API_VERSION_DATE_FORMAT, Locale.getDefault());
        Date currentDate = Calendar.getInstance().getTime();
        return apiVersionDateFormat.format(currentDate);
    }
}
