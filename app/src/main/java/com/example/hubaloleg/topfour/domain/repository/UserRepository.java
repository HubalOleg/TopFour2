package com.example.hubaloleg.topfour.domain.repository;

import com.example.hubaloleg.topfour.domain.model.UserInfo;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 10.07.17.
 */

public interface UserRepository {
    Observable<UserInfo> retrieveUserInfo(String token);
}
