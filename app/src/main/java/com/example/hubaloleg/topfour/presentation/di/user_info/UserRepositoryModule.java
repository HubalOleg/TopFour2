package com.example.hubaloleg.topfour.presentation.di.user_info;

import com.example.hubaloleg.topfour.data.local.LocalUserStorage;
import com.example.hubaloleg.topfour.data.local.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.api.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.model.entity.mapper.UserEntityDataMapper;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteUserStorage;
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
    LocalUserStorage provideLocalStorage() {
        return new LocalUserStorage();
    }

    @Provides
    @UserInfoScope
    RemoteUserStorage provideRemoteStorage(ApiInterface apiInterface, CredentialStore credentialStore) {
        return new RemoteUserStorage(apiInterface, credentialStore);
    }

    @Provides
    @UserInfoScope
    UserEntityDataMapper provideUserEntityDataMapper() {
        return new UserEntityDataMapper();
    }

    @Provides
    @UserInfoScope
    UserRepositoryImpl provideUserRepositoryImpl(LocalUserStorage localUserStorage, RemoteUserStorage remoteUserStorage, UserEntityDataMapper dataMapper) {
        return new UserRepositoryImpl(localUserStorage, remoteUserStorage, dataMapper);
    }
}
