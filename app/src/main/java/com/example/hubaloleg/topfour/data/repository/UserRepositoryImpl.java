package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.cache.UserCacheTransformer;
import com.example.hubaloleg.topfour.data.remote.api.UserApi;
import com.example.hubaloleg.topfour.data.mapper.UserMapper;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;

import io.reactivex.Observable;

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
                .map(userInfoResponseResponseEntity -> userInfoResponseResponseEntity.getResponse().getUserEntity())
                .map(mDataMapper::transformToDB)
                .compose(mCacheTransformer)
                .map(mDataMapper::transform);
    }
}
