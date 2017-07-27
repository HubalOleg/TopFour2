package com.example.hubaloleg.topfour.data.cache;

import com.example.hubaloleg.topfour.data.cache.db.CategoryDB;
import com.example.hubaloleg.topfour.data.cache.db.VenueDB;
import com.example.hubaloleg.topfour.data.cache.db.VenueDB_CategoryDB;
import com.raizlabs.android.dbflow.sql.language.SQLite;

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

    private final Function<List<VenueDB>, ObservableSource<List<VenueDB>>> mSaveFunc = venueDBList -> {
        SQLite.delete().from(VenueDB.class).execute();
        for (VenueDB venueDB : venueDBList) {
            venueDB.save();
            for (CategoryDB categoryDB : venueDB.getCategoryDBList()) {
                VenueDB_CategoryDB venueDB_categoryDB = new VenueDB_CategoryDB();
                venueDB_categoryDB.setVenueDB(venueDB);
                venueDB_categoryDB.setCategoryDB(categoryDB);
                venueDB_categoryDB.save();
            }
        }
        return Observable.just(venueDBList);
    };

    private final Function<Throwable, Observable<List<VenueDB>>> mCacheErrorHandle = throwable -> {
        throwable.printStackTrace();
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
