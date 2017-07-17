package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.usecase.UserInfoUseCase;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view.ProfileView;

import javax.inject.Inject;

/**
 * Created by kostya on 11.07.17.
 */

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private final UserInfoUseCase mUserUseCase;

    @Inject
    ProfilePresenter(UserInfoUseCase userInfoUseCase) {
        mUserUseCase = userInfoUseCase;
    }

    public void loadUserData() {
        mUserUseCase.loadUserInfo()
                .subscribe(userInfo -> getViewState().showUserInfo(userInfo),
                        throwable -> getViewState().userFetchFailure());
    }
}
