package com.example.hubaloleg.topfour.presentation.screens.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.data.local.prefs.CredentialStore;
import com.example.hubaloleg.topfour.presentation.di.component.CredentialComponent;
import com.example.hubaloleg.topfour.presentation.di.component.DaggerCredentialComponent;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.splash.presenter.SplashPresenter;
import com.example.hubaloleg.topfour.presentation.screens.splash.view.SplashView;

import javax.inject.Inject;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {
    public static final String TAG = "SplashActivity";

    @Inject
    @InjectPresenter
    SplashPresenter mSplashPresenter;

    @ProvidePresenter
    SplashPresenter provideSplashPresenter() {
        return mSplashPresenter;
    }

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, SplashActivity.class);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initInjection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    private void initInjection() {
        DaggerCredentialComponent.builder()
                .appComponent(TopFourApplication.getAppComponent())
                .build()
                .inject(SplashActivity.this);
    }
}
