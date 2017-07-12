package com.example.hubaloleg.topfour.presentation.screens.near_venue.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.usecase.SearchVenueUseCase;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.view.NearVenueView;

import javax.inject.Inject;

@InjectViewState
public class NearVenuePresenter extends MvpPresenter<NearVenueView> {

    private static final String TAG = "NearVenuePresenter";

    private static final String MOCK_COORDINATES = "49.815226, 24.157680";

    private final SearchVenueUseCase mSearchVenueUseCase;

    @Inject
    public NearVenuePresenter(SearchVenueUseCase searchVenueUseCase) {
        mSearchVenueUseCase = searchVenueUseCase;
    }

    public void onSearchVenuesClick(String coordinates) {
        mSearchVenueUseCase.searchVenuesWithCoordinates(MOCK_COORDINATES)
                .subscribe(
                        venues -> Log.d(TAG, "onSearchVenuesClick: " + venues.size()),
                        throwable -> Log.d(TAG, "onSearchVenuesClick: " + throwable.getMessage()));
    }

}
