package com.example.hubaloleg.topfour.presentation.di.user_info;

import com.example.hubaloleg.topfour.data.cache.UserCache;
import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.mapper.UserMapper;
import com.example.hubaloleg.topfour.data.remote.api.UserApi;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.data.repository.UserRepositoryImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kostya on 11.07.17.
 */

@Module
public class UserRepositoryModule {

    @Provides
    @UserInfoScope
    UserCache provideUserCache() {
        return new UserCache();
    }

    @Provides
    @UserInfoScope
    UserApi provideUserApi(ApiInterface apiInterface, CredentialStore credentialStore) {
        return new UserApi(apiInterface, credentialStore);
    }

    @Provides
    @UserInfoScope
    UserMapper provideUserMapper() {
        return new UserMapper();
    }

    @Provides
    @UserInfoScope
    UserRepositoryImpl provideUserRepositoryImpl(UserCache userCache, UserApi userApi, UserMapper dataMapper) {
        return new UserRepositoryImpl(userCache, userApi, dataMapper);
    }
}
