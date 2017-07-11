package com.example.hubaloleg.topfour.data.remote.api;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;

/**
 * Created by hubaloleg on 11.07.17.
 */

public abstract class BaseDataApi {

    final ApiInterface mApiInterface;
    final String mToken;
    final String mApiVersion;

    public BaseDataApi(ApiInterface apiInterface, CredentialStore credentialStore, @ApiVersion String apiVersion) {
        mToken = credentialStore.loadToken();
        mApiInterface = apiInterface;
        mApiVersion = apiVersion;
    }


}
