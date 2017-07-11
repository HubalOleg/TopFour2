package com.example.hubaloleg.topfour.presentation.di.module.user_info;

import com.example.hubaloleg.topfour.data.local.LocalStorage;
import com.example.hubaloleg.topfour.data.local.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.api.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.model.entity.mapper.UserEntityDataMapper;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteStorage;
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
    LocalStorage provideLocalStorage() {
        return new LocalStorage();
    }

    @Provides
    @UserInfoScope
    RemoteStorage provideRemoteStorage(ApiInterface apiInterface, CredentialStore credentialStore) {
        return new RemoteStorage(apiInterface, credentialStore);
    }

    @Provides
    @UserInfoScope
    UserEntityDataMapper provideUserEntityDataMapper() {
        return new UserEntityDataMapper();
    }

    @Provides
    @UserInfoScope
    UserRepositoryImpl provideUserRepositoryImpl(LocalStorage localStorage, RemoteStorage remoteStorage, UserEntityDataMapper dataMapper) {
        return new UserRepositoryImpl(localStorage, remoteStorage, dataMapper);
    }
}
