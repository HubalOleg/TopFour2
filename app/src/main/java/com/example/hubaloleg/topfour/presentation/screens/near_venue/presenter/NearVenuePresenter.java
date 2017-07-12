package com.example.hubaloleg.topfour.presentation.screens.near_venue.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.usecase.SearchVenueUseCase;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.view.NearVenueView;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class NearVenuePresenter extends MvpPresenter<NearVenueView> {

    private static final String TAG = "NearVenuePresenter";

    private static final String MOCK_COORDINATES = "49.815226, 24.157680";

    private final SearchVenueUseCase mSearchVenueUseCase;
    private Disposable mDisposable;

    @Inject
    public NearVenuePresenter(SearchVenueUseCase searchVenueUseCase) {
        mSearchVenueUseCase = searchVenueUseCase;
    }

    public void onSearchVenuesClick(String coordinates) {
        mSearchVenueUseCase.searchVenuesWithCoordinates(MOCK_COORDINATES)
                .doOnSubscribe(disposable -> {
                    mDisposable = disposable;
                    getViewState().showLoading();
                })
                .doOnTerminate(() -> getViewState().dismissLoading())
                .subscribe(
                        venues -> getViewState().showVenues(venues),
                        throwable -> {
                            throwable.printStackTrace();
                            getViewState().showError(throwable.getMessage());
                        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposable.dispose();
    }
}
