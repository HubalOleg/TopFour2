package com.example.hubaloleg.topfour.data.remote.api;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class UserApi {

    public static final String TEST_VERSION = "20171107";
    private final ApiInterface mApiInterface;
    private final CredentialStore mCredentialStore;
    private final String mApiVersion;

    @Inject
    public UserApi(ApiInterface apiInterface, CredentialStore credentialStore, @ApiVersion String apiVersion) {
        mApiInterface = apiInterface;
        mCredentialStore = credentialStore;
        mApiVersion = apiVersion;
    }


    public Observable<ResponseEntity<UserInfoResponse>> loadUserInfo(String token) {
        return mApiInterface.
                getUserProfileInfo(token, mApiVersion)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
