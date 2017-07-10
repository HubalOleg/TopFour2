package com.example.hubaloleg.topfour.presentation.di.component;

import com.example.hubaloleg.topfour.presentation.di.module.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hubaloleg on 10.07.17.
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface AppComponent {
}
