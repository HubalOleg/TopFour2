package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.cache.UserCacheTransformer;
import com.example.hubaloleg.topfour.data.remote.api.UserApi;
import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;
import com.example.hubaloleg.topfour.data.cache.UserCache;
import com.example.hubaloleg.topfour.data.mapper.UserMapper;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class UserRepositoryImpl implements UserRepository {

    private final UserApi mUserApi;
    private final UserMapper mDataMapper;
    private final UserCacheTransformer mCacheTransformer;

    public UserRepositoryImpl(UserCacheTransformer transformer, UserApi userApi, UserMapper dataMapper) {
        mCacheTransformer = transformer;
        mUserApi = userApi;
        mDataMapper = dataMapper;
    }

    @Override
    public Observable<UserInfo> retrieveUserInfo() {
        return mUserApi.loadUserInfo()
                .map(ResponseEntity::getResponse)
                .map(UserInfoResponse::getUserEntity)
                .compose(new UserCacheTransformer())
                .map(mDataMapper::transform);
    }
}
