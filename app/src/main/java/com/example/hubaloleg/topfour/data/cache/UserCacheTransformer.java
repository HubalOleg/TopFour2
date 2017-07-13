package com.example.hubaloleg.topfour.data.cache;

import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;

/**
 * Created by kostya on 13.07.17.
 */

public class UserCacheTransformer implements ObservableTransformer<UserEntity, UserEntity> {

    @Override
    public ObservableSource<UserEntity> apply(@NonNull Observable<UserEntity> upstream) {
        return null;
    }
}
