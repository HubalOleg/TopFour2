package com.example.hubaloleg.topfour.ui.activity.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.hubaloleg.topfour.presentation.view.splash.SplashView;
import com.example.hubaloleg.topfour.presentation.presenter.splash.SplashPresenter;

import com.arellomobile.mvp.MvpAppCompatActivity;

import com.example.hubaloleg.topfour.R;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {
    public static final String TAG = "SplashActivity";
    @InjectPresenter
    SplashPresenter mSplashPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, SplashActivity.class);

        return intent;
    }

    @ProvidePresenter
    SplashPresenter providePresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
