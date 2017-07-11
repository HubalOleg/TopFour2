package com.example.hubaloleg.topfour.presentation.di.module;

import com.example.hubaloleg.topfour.data.local.LocalStorage;
import com.example.hubaloleg.topfour.data.local.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.api.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hubal on 7/10/2017.
 */

@Module
public class StorageModule {

    @Provides
    @Singleton
    LocalStorage provideLocalStorage() {
        return new LocalStorage();
    }

    @Provides
    @Singleton
    RemoteStorage provideRemoteStorage(ApiInterface apiInterface, CredentialStore credentialStore) {
        return new RemoteStorage(apiInterface, credentialStore);
    }
}
