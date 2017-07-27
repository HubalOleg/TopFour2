package com.example.hubaloleg.topfour.presentation.di.modules.venue;

import com.example.hubaloleg.topfour.presentation.mapper.VenueUIMapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hubaloleg on 14.07.17.
 */

@Module
@VenueScope
public class VenuePresentationModule {

    @Provides
    VenueUIMapper provideVenueUIMapper() {
        return new VenueUIMapper();
    }
}
