package com.example.hubaloleg.topfour.presentation.screens.near_venues;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.screens.splash.SplashActivity;

import butterknife.ButterKnife;

public class NearVenuesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_venues);
        ButterKnife.bind(NearVenuesActivity.this);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, NearVenuesActivity.class);
    }
}
