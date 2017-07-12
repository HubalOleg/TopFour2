package com.example.hubaloleg.topfour.presentation.screens.near_venue.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.usecase.SearchVenueUseCase;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.view.NearVenueView;

import javax.inject.Inject;

@InjectViewState
public class NearVenuePresenter extends MvpPresenter<NearVenueView> {

    private final SearchVenueUseCase mSearchVenueUseCase;

    @Inject
    public NearVenuePresenter(SearchVenueUseCase searchVenueUseCase) {
        mSearchVenueUseCase = searchVenueUseCase;
    }


}
