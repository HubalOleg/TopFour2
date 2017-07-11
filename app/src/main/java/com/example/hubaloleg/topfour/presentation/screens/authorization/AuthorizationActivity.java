package com.example.hubaloleg.topfour.presentation.screens.authorization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.usecase.CredentialUseCase;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.authorization.presenter.AuthorizationPresenter;
import com.example.hubaloleg.topfour.presentation.screens.authorization.view.AuthorizationView;
import com.example.hubaloleg.topfour.presentation.screens.main.MainActivity;
import com.example.hubaloleg.topfour.presentation.screens.splash.SplashActivity;
import com.foursquare.android.nativeoauth.FoursquareOAuth;
import com.foursquare.android.nativeoauth.model.AuthCodeResponse;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.hubaloleg.topfour.BuildConfig.CLIENT_ID;
import static com.example.hubaloleg.topfour.BuildConfig.CLIENT_SECRET;

/**
 * Created by kostya on 10.07.17.
 */

public class AuthorizationActivity extends MvpAppCompatActivity
        implements AuthorizationView {

    private static final int RC_LOGIN = 1;

    private static final int REQUEST_CODE_FSQ_TOKEN_EXCHANGE = 201;
    private static final int REQUEST_CODE_FSQ_CONNECT = 200;

    @Inject
    @InjectPresenter
    AuthorizationPresenter mPresenter;

    @ProvidePresenter
    AuthorizationPresenter provideAuthPresenter() {
        initInjection();
        return mPresenter;
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, AuthorizationActivity.class);
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
        handleOnActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.btn_login_foursquare)
    public void onClickFoursquareLogin() {
        handleLoginClick();
    }

    private void initInjection() {

    }

    private void handleLoginClick() {
        Intent intent = FoursquareOAuth.getConnectIntent(AuthorizationActivity.this, CLIENT_ID);
        if (FoursquareOAuth.isPlayStoreIntent(intent))
            startActivity(intent);
        else
            startActivityForResult(intent, REQUEST_CODE_FSQ_CONNECT);
    }

    private void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_FSQ_CONNECT)
            onCompleteConnect(resultCode, data);
        else if (requestCode == REQUEST_CODE_FSQ_TOKEN_EXCHANGE)
            handleFSQTokenExchange(FoursquareOAuth.getTokenFromResult(resultCode, data)
                    .getAccessToken());

    }

    private void onCompleteConnect(int resultCode, Intent data) {
        AuthCodeResponse codeResponse = FoursquareOAuth.getAuthCodeFromResult(resultCode, data);
        Exception exception = codeResponse.getException();
        if (exception == null) {
            String code = codeResponse.getCode();
            Intent intent = FoursquareOAuth.getTokenExchangeIntent(AuthorizationActivity.this, CLIENT_ID, CLIENT_SECRET, code);
            startActivityForResult(intent, REQUEST_CODE_FSQ_TOKEN_EXCHANGE);
        }
    }

    private void handleFSQTokenExchange(String token) {
        mPresenter.storeToken(token);
    }

    @Override
    public void startMainActivity() {
        startActivity(MainActivity.getIntent(AuthorizationActivity.this));
    }
}
