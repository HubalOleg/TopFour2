package com.example.hubaloleg.topfour.presentation.screens.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.screens.splash.presenter.SplashPresenter;
import com.example.hubaloleg.topfour.presentation.screens.splash.view.SplashView;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {
    public static final String TAG = "SplashActivity";
    @InjectPresenter
    SplashPresenter mSplashPresenter;


    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, SplashActivity.class);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
