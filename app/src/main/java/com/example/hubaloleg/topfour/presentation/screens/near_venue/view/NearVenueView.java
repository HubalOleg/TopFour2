package com.example.hubaloleg.topfour.presentation.screens.near_venue.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.hubaloleg.topfour.presentation.model.VenueUI;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NearVenueView extends MvpView {
    void showVenues(List<VenueUI> venueList);
    @StateStrategyType(SkipStrategy.class)
    void showError(String error);
    void showLoading();
    void dismissLoading();
}
