package com.example.hubaloleg.topfour.domain.usecase;

import android.util.Log;

import com.example.hubaloleg.topfour.domain.repository.VenueRepository;
import com.example.hubaloleg.topfour.presentation.di.qualifier.SchedulerUI;

import javax.inject.Inject;

import io.reactivex.Scheduler;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class SearchVenueUseCase {

    private static final String TAG = "SearchVenueUseCase";

    private final VenueRepository mVenueRepository;
    private final Scheduler mSchedulerUI;

    @Inject
    SearchVenueUseCase(VenueRepository venueRepository, @SchedulerUI Scheduler schedulerUI) {
        mVenueRepository = venueRepository;
        mSchedulerUI = schedulerUI;

        Log.d(TAG, "SearchVenueUseCase: " + schedulerUI);
    }


}
