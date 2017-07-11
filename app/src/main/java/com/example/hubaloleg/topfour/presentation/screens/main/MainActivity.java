package com.example.hubaloleg.topfour.presentation.screens.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.NearVenueFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        putNearVenueFragment(savedInstanceState);
    }

    private void putNearVenueFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            putFragment(R.id.fl_near_venue_container,
                    NearVenueFragment.newInstance(),
                    NearVenueFragment.class.getSimpleName());
        }
    }

    private void putFragment(int containerId, Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment, tag)
                .commit();
    }


}
