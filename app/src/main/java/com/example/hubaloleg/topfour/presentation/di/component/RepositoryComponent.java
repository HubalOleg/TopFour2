package com.example.hubaloleg.topfour.presentation.di.component;

import com.example.hubaloleg.topfour.presentation.di.module.RepositoryModule;
import com.example.hubaloleg.topfour.presentation.di.scopes.PerActivity;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.NearVenueFragment;

import dagger.Component;

/**
 * Created by hubaloleg on 11.07.17.
 */

@PerActivity
@Component(dependencies = AppComponent.class,
        modules = RepositoryModule.class)
public interface RepositoryComponent {

    void inject(NearVenueFragment nearVenueFragment);
}
