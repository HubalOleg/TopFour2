package com.example.hubaloleg.topfour.presentation.screens.authorization.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.domain.usecase.CredentialUseCase;
import com.example.hubaloleg.topfour.presentation.screens.authorization.view.AuthorizationView;

import javax.inject.Inject;

/**
 * Created by kostya on 10.07.17.
 */

@InjectViewState
public class AuthorizationPresenter extends MvpPresenter<AuthorizationView> {
    private CredentialUseCase mCredentialUseCase;

    @Inject
    public AuthorizationPresenter(CredentialUseCase credentialUseCase) {
        mCredentialUseCase = credentialUseCase;
    }

    public void storeToken(String token) {
        mCredentialUseCase.storeToken(token);
    }
}
