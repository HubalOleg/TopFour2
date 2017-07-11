package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.local.LocalStorage;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteStorage;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.AppRepository;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class AppRepositoryImpl implements AppRepository{

    private final LocalStorage mLocalStorage;
    private final RemoteStorage mRemoteStorage;

    public AppRepositoryImpl(LocalStorage localStorage, RemoteStorage remoteStorage) {
        mLocalStorage = localStorage;
        mRemoteStorage = remoteStorage;
    }

    @Override
    public Observable<UserInfo> retrieveUserInfo() {

        return null;
    }
}
