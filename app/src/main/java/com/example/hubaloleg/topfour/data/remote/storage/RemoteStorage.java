package com.example.hubaloleg.topfour.data.remote.storage;

import com.example.hubaloleg.topfour.data.remote.api.ApiInterface;

import javax.inject.Inject;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class RemoteStorage {

    private final ApiInterface mApiInterface;

    @Inject
    public RemoteStorage(ApiInterface apiInterface) {
        mApiInterface = apiInterface;
    }


}
