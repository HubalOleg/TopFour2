package com.example.hubaloleg.topfour.presentation.di.venue;

import com.example.hubaloleg.topfour.data.cache.VenueCache;
import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.mapper.VenueMapper;
import com.example.hubaloleg.topfour.data.remote.api.VenueApi;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.data.repository.VenueRepositoryImpl;
import com.example.hubaloleg.topfour.domain.repository.VenueRepository;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hubaloleg on 11.07.17.
 */

@Module
@VenueScope
public class VenueRepositoryModule {

    @Provides
    VenueCache provideUserCache() {
        return new VenueCache();
    }

    @Provides
    VenueApi provideUserApi(ApiInterface apiInterface,
                            CredentialStore credentialStore,
                            @ApiVersion String apiVersion) {
        return new VenueApi(apiInterface, credentialStore, apiVersion);
    }

    @Provides
    VenueMapper provideUserMapper() {
        return new VenueMapper();
    }

    @Provides
    VenueRepository provideUserRepository(VenueCache venueCache, VenueApi venueApi, VenueMapper dataMapper) {
        return new VenueRepositoryImpl(venueCache, venueApi, dataMapper);
    }
}
