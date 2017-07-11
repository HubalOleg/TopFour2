package com.example.hubaloleg.topfour.domain.usecase;

import android.text.TextUtils;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;

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

}
