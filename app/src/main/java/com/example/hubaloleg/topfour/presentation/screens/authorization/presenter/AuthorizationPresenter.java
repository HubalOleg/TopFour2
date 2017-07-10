package com.example.hubaloleg.topfour.presentation.screens.authorization.presenter;

import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.hubaloleg.topfour.data.security.SecurityManager;
import com.example.hubaloleg.topfour.presentation.screens.authorization.view.AuthorizationView;
import com.foursquare.android.nativeoauth.FoursquareOAuth;
import com.foursquare.android.nativeoauth.model.AccessTokenResponse;

import javax.inject.Inject;

/**
 * Created by kostya on 10.07.17.
 */

@InjectViewState
public class AuthorizationPresenter extends MvpPresenter<AuthorizationView> {
    private static final int REQUEST_CODE_FSQ_TOKEN_EXCHANGE = 201;
    private static final int REQUEST_CODE_FSQ_CONNECT = 200;

    private SecurityManager mSecurityManager;

    @Inject
    public AuthorizationPresenter(SecurityManager securityManager) {
        mSecurityManager = securityManager;
    }
}
