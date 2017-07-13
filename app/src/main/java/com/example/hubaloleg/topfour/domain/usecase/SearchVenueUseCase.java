package com.example.hubaloleg.topfour.domain.usecase;

import com.example.hubaloleg.topfour.domain.model.Venue;
import com.example.hubaloleg.topfour.domain.repository.VenueRepository;
import com.example.hubaloleg.topfour.presentation.di.qualifier.SchedulerUI;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class SearchVenueUseCase {

    private static final int ITEMS_LIMIT = 20;

    private final VenueRepository mVenueRepository;
    private final Scheduler mSchedulerUI;

    @Inject
    SearchVenueUseCase(VenueRepository venueRepository, @SchedulerUI Scheduler schedulerUI) {
        mVenueRepository = venueRepository;
        mSchedulerUI = schedulerUI;
    }

    public Observable<List<Venue>> searchVenuesWithCoordinates(String coordinates) {
        return mVenueRepository.searchVenuesWithCoordinates(coordinates, ITEMS_LIMIT)
                .subscribeOn(Schedulers.io())
                .observeOn(mSchedulerUI);
    }
}
