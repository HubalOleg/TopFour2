package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.remote.api.UserApi;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;
import com.example.hubaloleg.topfour.data.cache.UserCache;
import com.example.hubaloleg.topfour.data.mapper.UserMapper;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class UserRepositoryImpl implements UserRepository {

    private final UserCache mUserCache;
    private final UserApi mUserApi;
    private final UserMapper mDataMapper;

    public UserRepositoryImpl(UserCache userCache, UserApi userApi, UserMapper dataMapper) {
        mUserCache = userCache;
        mUserApi = userApi;
        mDataMapper = dataMapper;
    }

    @Override
    public Observable<UserInfo> retrieveUserInfo(String token) {
//        if (mUserCache.isUserInfoValid())
        Observable<ResponseEntity<UserInfoResponse>> observable = mUserApi.loadUserInfo(token);
        return observable.map(userInfoResponseResponseEntity -> mDataMapper.transform(userInfoResponseResponseEntity.getResponse().getUserEntity()));
    }
}
