package com.example.hubaloleg.topfour.presentation.di.venue;

import com.example.hubaloleg.topfour.presentation.di.global.AppComponent;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.NearVenueFragment;

import dagger.Component;

/**
 * Created by hubaloleg on 11.07.17.
 */

@VenueScope
@Component(dependencies = AppComponent.class,
        modules = VenueRepositoryModule.class)
public interface VenueComponent {

    void inject(NearVenueFragment nearVenueFragment);
}
