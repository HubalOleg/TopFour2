package com.example.hubaloleg.topfour.presentation.screens.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view.ProfileFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements ProfileFragment.OnProfileFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        if (savedInstanceState == null) {
            openFragment(ProfileFragment.newInstance(), ProfileFragment.class.getSimpleName(), false);
        }
    }

    @Override
    public void openHistoryScreen() {

    }

    @Override
    public void openListsScreen() {

    }

    public void openFragment(Fragment fragment, String tag, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_container, fragment, tag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (addToBackStack)
            ft.addToBackStack(null);
        ft.commit();
    }
}
