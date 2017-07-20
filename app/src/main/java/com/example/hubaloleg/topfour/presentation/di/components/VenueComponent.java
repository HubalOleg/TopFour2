package com.example.hubaloleg.topfour.presentation.di.components;

import com.example.hubaloleg.topfour.presentation.di.global.AppComponent;
import com.example.hubaloleg.topfour.presentation.di.modules.venue.VenueRepositoryModule;
import com.example.hubaloleg.topfour.presentation.di.modules.venue.VenueScope;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.NearVenueFragment;
import com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map.LikedPlaceAppActivity;

import dagger.Component;

/**
 * Created by hubaloleg on 11.07.17.
 */

@VenueScope
@Component(dependencies = AppComponent.class,
        modules = VenueRepositoryModule.class)
public interface VenueComponent {

    void inject(NearVenueFragment nearVenueFragment);

    void inject(LikedPlaceAppActivity likedPlaceAppActivity);
}
