package com.example.hubaloleg.topfour.data.remote.storage;

import com.example.hubaloleg.topfour.data.local.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.api.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class RemoteUserStorage {

    private final ApiInterface mApiInterface;
    private final CredentialStore mCredentialStore;

    @Inject
    public RemoteUserStorage(ApiInterface apiInterface, CredentialStore credentialStore) {
        mApiInterface = apiInterface;
        mCredentialStore = credentialStore;
    }


    public Observable<ResponseEntity<UserInfoResponse>> loadUserInfo(String token) {
        return mApiInterface.
                getUserProfileInfo(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
