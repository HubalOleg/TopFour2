package com.example.hubaloleg.topfour.presentation.screens.near_venue.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.hubaloleg.topfour.domain.model.venues.Venue;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NearVenueView extends MvpView {
    void showVenues(List<Venue> venueList);
    void showError(String error);
    void showLoading();
    void dismissLoading();
}
