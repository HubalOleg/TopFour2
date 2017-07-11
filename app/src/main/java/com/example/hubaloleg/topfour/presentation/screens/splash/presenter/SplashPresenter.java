package com.example.hubaloleg.topfour.presentation.screens.splash.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.usecase.CredentialUseCase;
import com.example.hubaloleg.topfour.presentation.screens.splash.view.SplashView;

import javax.inject.Inject;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private final CredentialUseCase mCredentialUseCase;

    @Inject
    public SplashPresenter(CredentialUseCase credentialUseCase) {
        mCredentialUseCase = credentialUseCase;
    }

    public void checkLoginState() {
        if (mCredentialUseCase.isAuthorized())
            getViewState().showNearVenues();
        else
            getViewState().showAuthorization();
    }
}
