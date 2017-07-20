package com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;
import com.example.hubaloleg.topfour.domain.model.venues.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LikedPlaceAppActivity extends FragmentActivity implements OnMapReadyCallback {

    public static final String EXTRA_LIKED_VENUE = "EXTRA_LIKED_VENUE";
    public static final float ZOOM = 13f;
    private GoogleMap mMap;
    private LikedVenue mLikedVenue;


    public static Intent getIntent(Context context) {
        return new Intent(context, LikedPlaceAppActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_place_app);
        claimExtra();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(LikedPlaceAppActivity.this);
    }

    private void claimExtra() {
        Bundle extra = getIntent().getExtras();
        if (extra != null)
            mLikedVenue = getIntent().getParcelableExtra(EXTRA_LIKED_VENUE);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        addMarker();
    }

    private void addMarker() {
        if (mLikedVenue != null && mLikedVenue.getLocation() != null) {
            Location location = mLikedVenue.getLocation();
            LatLng coordinates = new LatLng(location.getLat(), location.getLng());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(coordinates);
            markerOptions.title(mLikedVenue.getName());
            mMap.addMarker(markerOptions);
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, ZOOM));
        }
    }
}
