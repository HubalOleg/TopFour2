package com.example.hubaloleg.topfour.presentation.screens.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.user.Item;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.NearVenueFragment;
import com.example.hubaloleg.topfour.presentation.screens.profile.group_items.GroupItemsFragment;
import com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map.LikedPlaceAppActivity;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view.ProfileFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements ProfileFragment.OnProfileFragmentInteractionListener,
        NearVenueFragment.OnNearVenueFragmentInteractionListener {

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
            openFragment(NearVenueFragment.newInstance(), NearVenueFragment.class.getSimpleName(), false);
        }
    }

    @Override
    public void onProfileClick() {
        openFragment(ProfileFragment.newInstance(), ProfileFragment.class.getSimpleName(), true);
    }

    @Override
    public void onGroupClick(ArrayList<Item> itemList) {
        openFragment(GroupItemsFragment.newInstance(itemList), GroupItemsFragment.class.getSimpleName(), true);
    }

    @Override
    public void onLikedVenueClick(LikedVenue likedVenue) {
        launchMapActivity(likedVenue);
    }

    private void launchMapActivity(LikedVenue likedVenue) {
        Intent intent = LikedPlaceAppActivity.getIntent(getApplicationContext());
        intent.putExtra(LikedPlaceAppActivity.EXTRA_LIKED_VENUE, likedVenue);
        startActivity(intent);
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
