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
import com.example.hubaloleg.topfour.domain.usecase.CredentialUseCase;
import com.example.hubaloleg.topfour.presentation.di.component.CredentialComponent;
import com.example.hubaloleg.topfour.presentation.di.component.DaggerCredentialComponent;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.authorization.AuthorizationActivity;
import com.example.hubaloleg.topfour.presentation.screens.near_venues.NearVenuesActivity;
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
        initInjection();
        return mSplashPresenter;
    }

    public static Intent getIntent(final Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashPresenter.checkLoginState();
    }

    private void initInjection() {
        DaggerCredentialComponent.builder()
                .appComponent(TopFourApplication.getAppComponent())
                .build()
                .inject(SplashActivity.this);
    }

    @Override
    public void showNearVenues() {
        startActivity(NearVenuesActivity.getIntent(SplashActivity.this));
    }

    @Override
    public void showAuthorization() {
        startActivity(AuthorizationActivity.getIntent(SplashActivity.this));
    }
}
