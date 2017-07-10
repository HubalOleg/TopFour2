package com.example.hubaloleg.topfour.presentation.di.module;

import com.example.hubaloleg.topfour.data.local.LocalStorage;
import com.example.hubaloleg.topfour.data.remote.storage.RemoteStorage;
import com.example.hubaloleg.topfour.data.repository.AppRepositoryImpl;
import com.example.hubaloleg.topfour.domain.repository.AppRepository;
import com.example.hubaloleg.topfour.presentation.di.scopes.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hubal on 7/10/2017.
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    AppRepository providesAppRepository(LocalStorage localStorage, RemoteStorage remoteStorage) {
        return new AppRepositoryImpl(localStorage, remoteStorage);
    }
}
