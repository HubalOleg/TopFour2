package com.example.hubaloleg.topfour.presentation.screens.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.screens.profile.ProfileFragment;

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
        replaceFragment(ProfileFragment.newInstance());
    }

    private void replaceFragment(ProfileFragment profileFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_profile_container, profileFragment)
                .commit();
    }
}
