package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.usecase.UserInfoUseCase;
import com.example.hubaloleg.topfour.domain.usecase.VenueUseCase;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view.ProfileView;

import javax.inject.Inject;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private final UserInfoUseCase mUserUseCase;
    private final VenueUseCase mVenueUseCase;

    @Inject
    ProfilePresenter(UserInfoUseCase userInfoUseCase, VenueUseCase venueUseCase) {
        mUserUseCase = userInfoUseCase;
        mVenueUseCase = venueUseCase;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadUserData();
        loadLikedVenues();
    }

    public void loadUserData() {
        mUserUseCase.loadUserInfo()
                .subscribe(userInfo -> getViewState().showUserInfo(userInfo),
                        throwable -> getViewState().userFetchFailure(throwable));
    }

    public void loadLikedVenues() {
        mVenueUseCase.getLikedVenueList()
                .subscribe(likedVenues -> getViewState().showLikedVenueList(likedVenues),
                        throwable -> getViewState().likedVenueFetchFailure(throwable));
    }
}
