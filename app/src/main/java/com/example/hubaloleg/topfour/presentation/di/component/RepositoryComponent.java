package com.example.hubaloleg.topfour.presentation.di.component;

import com.example.hubaloleg.topfour.presentation.di.module.CredentialModule;
import com.example.hubaloleg.topfour.presentation.di.module.NetworkModule;
import com.example.hubaloleg.topfour.presentation.di.module.RepositoryModule;
import com.example.hubaloleg.topfour.presentation.di.module.StorageModule;
import com.example.hubaloleg.topfour.presentation.di.scopes.PerActivity;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.NearVenueFragment;

import dagger.Component;

/**
 * Created by hubaloleg on 11.07.17.
 */

@PerActivity
@Component(dependencies = AppComponent.class,
        modules = {CredentialModule.class,
                NetworkModule.class,
                StorageModule.class,
                RepositoryModule.class})
public interface RepositoryComponent {

    void inject(NearVenueFragment nearVenueFragment);
}
