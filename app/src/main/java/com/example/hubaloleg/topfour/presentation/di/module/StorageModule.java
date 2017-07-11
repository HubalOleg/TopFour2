package com.example.hubaloleg.topfour.presentation.di.module;

import com.example.hubaloleg.topfour.data.local.LocalStorage;
import com.example.hubaloleg.topfour.data.local.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.api.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteStorage;
import com.example.hubaloleg.topfour.presentation.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hubal on 7/10/2017.
 */

@Module(includes = {CredentialModule.class, NetworkModule.class})
public class StorageModule {

    @Provides
    @PerActivity
    LocalStorage provideLocalStorage() {
        return new LocalStorage();
    }

    @Provides
    @PerActivity
    RemoteStorage provideRemoteStorage(ApiInterface apiInterface, CredentialStore credentialStore) {
        return new RemoteStorage(apiInterface, credentialStore);
    }
}
