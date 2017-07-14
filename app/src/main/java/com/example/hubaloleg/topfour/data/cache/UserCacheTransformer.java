package com.example.hubaloleg.topfour.data.cache;

import com.example.hubaloleg.topfour.data.cache.db.UserDB;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by kostya on 13.07.17.
 */

public class UserCacheTransformer implements ObservableTransformer<UserDB, UserDB> {

    private Function<UserDB, ObservableSource<UserDB>> mSaveFunc = userDB -> {
        userDB.save();
        return Observable.just(userDB);
    };

    private Function<Throwable, Observable<UserDB>> mUserCacheErrorHandler = throwable -> {
        throwable.printStackTrace();
        UserDB userDB = SQLite.select().from(UserDB.class).querySingle();
        return Observable.just(userDB);
    };

    @Override
    public ObservableSource<UserDB> apply(@NonNull Observable<UserDB> upstream) {
        return upstream
                .flatMap(mSaveFunc)
                .onErrorResumeNext(mUserCacheErrorHandler);
    }
}
