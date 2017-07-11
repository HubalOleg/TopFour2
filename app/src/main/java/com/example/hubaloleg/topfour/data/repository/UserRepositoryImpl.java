package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.local.LocalUserStorage;
import com.example.hubaloleg.topfour.data.remote.model.entity.mapper.UserEntityDataMapper;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteUserStorage;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class UserRepositoryImpl implements UserRepository {

    private final LocalUserStorage mLocalUserStorage;
    private final RemoteUserStorage mRemoteUserStorage;
    private final UserEntityDataMapper mDataMapper;

    public UserRepositoryImpl(LocalUserStorage localUserStorage, RemoteUserStorage remoteUserStorage, UserEntityDataMapper dataMapper) {
        mLocalUserStorage = localUserStorage;
        mRemoteUserStorage = remoteUserStorage;
        mDataMapper = dataMapper;
    }

    @Override
    public Observable<UserInfo> retrieveUserInfo(String token) {
//        if (mLocalUserStorage.isUserInfoValid())
        Observable<ResponseEntity<UserInfoResponse>> observable = mRemoteUserStorage.loadUserInfo(token);
        return observable.map(userInfoResponseResponseEntity -> mDataMapper.transform(userInfoResponseResponseEntity.getResponse().getUserEntity()));
    }
}
