package com.example.hubaloleg.topfour.presentation.di.module.user_info;

import com.example.hubaloleg.topfour.presentation.di.module.global.AppComponent;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.NearVenueFragment;
import com.example.hubaloleg.topfour.presentation.screens.profile.ProfileFragment;

import dagger.Component;

/**
 * Created by hubaloleg on 11.07.17.
 */

@Component(dependencies = AppComponent.class,
        modules = UserRepositoryModule.class)
@UserInfoScope
public interface UserInfoComponent {

    void inject(ProfileFragment fragment);
}
