package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.local.LocalStorage;
import com.example.hubaloleg.topfour.data.remote.model.entity.mapper.UserEntityDataMapper;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteStorage;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class UserRepositoryImpl implements UserRepository {

    private final LocalStorage mLocalStorage;
    private final RemoteStorage mRemoteStorage;
    private final UserEntityDataMapper mDataMapper;

    public UserRepositoryImpl(LocalStorage localStorage, RemoteStorage remoteStorage, UserEntityDataMapper dataMapper) {
        mLocalStorage = localStorage;
        mRemoteStorage = remoteStorage;
        mDataMapper = dataMapper;
    }

    @Override
    public Observable<UserInfo> retrieveUserInfo() {
//        if (mLocalStorage.isUserInfoValid())
        Observable<ResponseEntity<UserInfoResponse>> observable = mRemoteStorage.loadUserInfo();
        return observable.map(userInfoResponseResponseEntity -> mDataMapper.transform(userInfoResponseResponseEntity.getResponse().getUserEntity()));
    }
}
