package com.example.hubaloleg.topfour.presentation.mvp.ui.activity.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.mvp.presentation.presenter.splash.SplashPresenter;
import com.example.hubaloleg.topfour.presentation.mvp.presentation.view.splash.SplashView;

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
