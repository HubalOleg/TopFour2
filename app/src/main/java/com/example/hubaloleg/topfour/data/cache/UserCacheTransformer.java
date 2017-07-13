package com.example.hubaloleg.topfour.data.cache;

import com.example.hubaloleg.topfour.data.cache.db.SavedUser;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by kostya on 13.07.17.
 */

public class UserCacheTransformer implements ObservableTransformer<SavedUser, SavedUser> {

    private Function<SavedUser, ObservableSource<SavedUser>> mSaveFunc = savedUser -> {
        savedUser.save();
        return Observable.just(savedUser);
    };

    private Function<Throwable, Observable<SavedUser>> mUserCacheErrorHandler = throwable -> {
        throwable.printStackTrace();
        SavedUser savedUser = SQLite.select().from(SavedUser.class).querySingle();
        return Observable.just(savedUser);
    };

    @Override
    public ObservableSource<SavedUser> apply(@NonNull Observable<SavedUser> upstream) {
        return upstream
                .flatMap(mSaveFunc)
                .onErrorResumeNext(mUserCacheErrorHandler);
    }
}
