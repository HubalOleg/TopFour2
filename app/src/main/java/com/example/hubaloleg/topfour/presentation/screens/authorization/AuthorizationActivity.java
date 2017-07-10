package com.example.hubaloleg.topfour.presentation.screens.authorization;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.BuildConfig;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.data.security.SecurityManager;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.authorization.presenter.AuthorizationPresenter;
import com.example.hubaloleg.topfour.presentation.screens.authorization.view.AuthorizationView;
import com.foursquare.android.nativeoauth.FoursquareOAuth;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kostya on 10.07.17.
 */

public class AuthorizationActivity extends MvpAppCompatActivity
        implements AuthorizationView {

    private static final int RC_LOGIN = 1;

    @InjectPresenter
    AuthorizationPresenter mPresenter;

    @Inject
    @ProvidePresenter
    AuthorizationPresenter provideAuthPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        ButterKnife.bind(AuthorizationActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.btn_login_foursquare)
    public void onClickFoursquareLogin() {
        handleLoginClick();
    }

    private void handleLoginClick() {
        Intent intent = FoursquareOAuth.getConnectIntent(AuthorizationActivity.this, BuildConfig.CLIENT_ID);
        if (FoursquareOAuth.isPlayStoreIntent(intent))
            startActivity(intent);
        else
            startActivityForResult(intent, RC_LOGIN);
    }
}
