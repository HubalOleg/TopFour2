package com.example.hubaloleg.topfour.presentation.screens.profile.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.domain.usecase.UserInfoUseCase;
import com.example.hubaloleg.topfour.presentation.screens.profile.view.ProfileView;

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

    public void loadUserData(String token) {
        mUserUseCase.loadUserInfo(token)
                .subscribe(userInfo -> getViewState().showUserInfo(userInfo),
                        throwable -> System.out.printf("error " + throwable));
    }
}
