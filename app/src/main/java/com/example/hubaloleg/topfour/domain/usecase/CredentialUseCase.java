package com.example.hubaloleg.topfour.domain.usecase;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.example.hubaloleg.topfour.data.local.prefs.CredentialStore;

import javax.inject.Inject;

/**
 * Created by hubal on 7/10/2017.
 */

public class CredentialUseCase {

    private final CredentialStore mCredentialStore;

    @Inject
    CredentialUseCase(CredentialStore credentialStore) {
        mCredentialStore = credentialStore;
    }

    public boolean isAuthorized() {
        return !TextUtils.isEmpty(mCredentialStore.loadToken());
    }

    public void storeToken(String token) {
        mCredentialStore.saveToken(token);
    }

    public String loadToken() {
        return mCredentialStore.loadToken();
    }

}
