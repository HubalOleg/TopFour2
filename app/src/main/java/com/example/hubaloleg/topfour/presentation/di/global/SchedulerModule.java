package com.example.hubaloleg.topfour.presentation.di.global;

import com.example.hubaloleg.topfour.presentation.di.qualifier.SchedulerUI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by hubaloleg on 12.07.17.
 */

@Module
@Singleton
public class SchedulerModule {

    @Provides
    @SchedulerUI
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

}
