package com.example.hubaloleg.topfour.presentation.screens.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.di.global.ApplicationModule;
import com.example.hubaloleg.topfour.presentation.di.global.DaggerAppComponent;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.authorization.AuthorizationActivity;
import com.example.hubaloleg.topfour.presentation.screens.main.MainActivity;
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

    @Override
    public void showMainScreen() {
        launchActivity(MainActivity.getIntent(SplashActivity.this));
    }

    @Override
    public void showAuthorization() {
        launchActivity(AuthorizationActivity.getIntent(SplashActivity.this));
    }

    private void initInjection() {
        TopFourApplication.getAppComponent()
                .inject(SplashActivity.this);
    }

    private void launchActivity(Intent intent) {
        startActivity(intent);
        finish();
    }
}
