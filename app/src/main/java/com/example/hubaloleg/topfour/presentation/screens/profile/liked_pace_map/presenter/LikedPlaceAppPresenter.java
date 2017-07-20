package com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;
import com.example.hubaloleg.topfour.domain.model.venues.Location;
import com.example.hubaloleg.topfour.domain.usecase.VenueUseCase;
import com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map.view.LikedPlaceAppView;

import javax.inject.Inject;

/**
 * Created by kostya on 20.07.17.
 */

@InjectViewState
public class LikedPlaceAppPresenter extends MvpPresenter<LikedPlaceAppView> {
    private VenueUseCase mVenueUseCase;

    @Inject
    public LikedPlaceAppPresenter(VenueUseCase venueUseCase) {
        mVenueUseCase = venueUseCase;
    }


    public void fetchMaxSpeed(Location location) {
        mVenueUseCase.fetchMaxSpeed(formQuery(location)).subscribe(elements -> {

        }, throwable -> getViewState().onError(throwable));
    }

    private String formQuery(Location location) {
//        return "[out:json];way[maxspeed](around:50.0," + 48.495864 + ","  + 20.372584 +");out tags;";
        return "[out:json];way[maxspeed](around:50.0,48.495864, 20.372584);out tags;";
    }
}
