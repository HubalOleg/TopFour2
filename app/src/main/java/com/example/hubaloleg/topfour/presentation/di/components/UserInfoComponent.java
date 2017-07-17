package com.example.hubaloleg.topfour.presentation.di.components;

import com.example.hubaloleg.topfour.presentation.di.global.AppComponent;
import com.example.hubaloleg.topfour.presentation.di.modules.user_info.UserInfoScope;
import com.example.hubaloleg.topfour.presentation.di.modules.user_info.UserRepositoryModule;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view.ProfileFragment;

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
