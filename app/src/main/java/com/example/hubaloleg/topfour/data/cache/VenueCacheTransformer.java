package com.example.hubaloleg.topfour.data.cache;

import android.util.Log;

import com.example.hubaloleg.topfour.data.cache.db.AppDatabase;
import com.example.hubaloleg.topfour.data.cache.db.VenueDB;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.FastStoreModelTransaction;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class VenueCacheTransformer implements ObservableTransformer<List<VenueDB>, List<VenueDB>> {

    private static final String TAG = "VenueCacheTransformer";

    private final Function<List<VenueDB>, ObservableSource<List<VenueDB>>> mSaveFunc = venueDBList -> {
        SQLite.delete().from(VenueDB.class).execute();
        FlowManager.getDatabase(AppDatabase.class).executeTransaction(
                FastStoreModelTransaction
                .insertBuilder(FlowManager.getModelAdapter(VenueDB.class))
                .addAll(venueDBList)
                .build());
        return Observable.just(venueDBList);
    };

    private final Function<Throwable, Observable<List<VenueDB>>> mCacheErrorHandle = throwable -> {
        throwable.printStackTrace();
        Log.d(TAG, ": " + throwable.getMessage());
        List<VenueDB> venueDBList = SQLite.select().from(VenueDB.class).queryList();
        return Observable.just(venueDBList);
    };

    @Override
    public ObservableSource<List<VenueDB>> apply(@NonNull Observable<List<VenueDB>> venueObservable) {
        return venueObservable
                .flatMap(mSaveFunc)
                .onErrorResumeNext(mCacheErrorHandle);
    }
}
