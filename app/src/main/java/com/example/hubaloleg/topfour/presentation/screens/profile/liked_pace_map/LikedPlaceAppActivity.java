package com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.elements.Element;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;
import com.example.hubaloleg.topfour.domain.model.venues.Location;
import com.example.hubaloleg.topfour.presentation.di.components.DaggerVenueComponent;
import com.example.hubaloleg.topfour.presentation.di.modules.venue.VenueRepositoryModule;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map.presenter.LikedPlaceAppPresenter;
import com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map.view.LikedPlaceAppView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LikedPlaceAppActivity extends MvpAppCompatActivity implements OnMapReadyCallback,
        LikedPlaceAppView {

    public static final String EXTRA_LIKED_VENUE = "EXTRA_LIKED_VENUE";
    public static final float ZOOM = 13f;
    private static final String TAG = LikedPlaceAppActivity.class.getSimpleName();
    private GoogleMap mMap;
    private LikedVenue mLikedVenue;

    @BindView(R.id.tv_max_speed)
    TextView mTvMaxSpeed;

    @InjectPresenter
    @Inject
    LikedPlaceAppPresenter mPresenter;

    @ProvidePresenter
    LikedPlaceAppPresenter provideLikedPlaceAppPresenter() {
        initInjection();
        return mPresenter;
    }

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
        ButterKnife.bind(LikedPlaceAppActivity.this);
        mPresenter.fetchMaxSpeed(mLikedVenue.getLocation());
    }

    private void initInjection() {
        DaggerVenueComponent
                .builder()
                .appComponent(TopFourApplication.getAppComponent())
                .venueRepositoryModule(new VenueRepositoryModule())
                .build()
                .inject(LikedPlaceAppActivity.this);
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

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void showElementList(List<Element> elements) {
        Log.d(TAG, "showElementList: ");
        if (!elements.isEmpty())
            mTvMaxSpeed.setText(elements.get(0).getTags().getMaxSpeed());
    }
}
