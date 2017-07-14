package com.example.hubaloleg.topfour.presentation.di.modules.user_info;

import com.example.hubaloleg.topfour.data.cache.UserCacheTransformer;
import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.mapper.UserMapper;
import com.example.hubaloleg.topfour.data.remote.api.UserApi;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.data.repository.UserRepositoryImpl;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kostya on 11.07.17.
 */

@Module
@UserInfoScope
public class UserRepositoryModule {

    @Provides
    UserApi provideUserApi(ApiInterface apiInterface,
                           CredentialStore credentialStore,
                           @ApiVersion String apiVersion) {
        return new UserApi(apiInterface, credentialStore, apiVersion);
    }

    @Provides
    UserMapper provideUserMapper() {
        return new UserMapper();
    }

    @Provides
    UserCacheTransformer provideUserCacheTransformer() {
        return new UserCacheTransformer();
    }

    @Provides
    UserRepository provideUserRepository(UserCacheTransformer cacheTransformer, UserApi userApi, UserMapper dataMapper) {
        return new UserRepositoryImpl(cacheTransformer, userApi, dataMapper);
    }
}
