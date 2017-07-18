package com.example.hubaloleg.topfour.presentation.di.modules.venue;

import com.example.hubaloleg.topfour.data.cache.VenueCacheTransformer;
import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.mapper.IconMapper;
import com.example.hubaloleg.topfour.data.mapper.venues.CategoryMapper;
import com.example.hubaloleg.topfour.data.mapper.venues.VenueMapper;
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
    VenueCacheTransformer provideUserCache() {
        return new VenueCacheTransformer();
    }

    @Provides
    VenueApi provideUserApi(ApiInterface apiInterface,
                            CredentialStore credentialStore,
                            @ApiVersion String apiVersion) {
        return new VenueApi(apiInterface, credentialStore, apiVersion);
    }

    @Provides
    IconMapper provideIconMapper() {
        return new IconMapper();
    }

    @Provides
    CategoryMapper provideCategoryMapper(IconMapper iconMapper) {
        return new CategoryMapper(iconMapper);
    }

    @Provides
    VenueMapper provideUserMapper(CategoryMapper categoryMapper) {
        return new VenueMapper(categoryMapper);
    }

    @Provides
    VenueRepository provideUserRepository(VenueCacheTransformer venueCacheTransformer, VenueApi venueApi, VenueMapper dataMapper) {
        return new VenueRepositoryImpl(venueCacheTransformer, venueApi, dataMapper);
    }
}
