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

public class UserApi extends BaseDataApi {

    @Inject
    public UserApi(ApiInterface apiInterface, CredentialStore credentialStore, @ApiVersion String apiVersion) {
        super(apiInterface, credentialStore, apiVersion);
    }


    public Observable<ResponseEntity<UserInfoResponse>> loadUserInfo() {
        return mApiInterface.
                getUserProfileInfo(mToken, mApiVersion)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
