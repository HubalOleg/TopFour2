package com.example.hubaloleg.topfour.domain.usecase;

import com.example.hubaloleg.topfour.data.repository.UserRepositoryImpl;
import com.example.hubaloleg.topfour.domain.model.UserInfo;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by kostya on 11.07.17.
 */

public class UserInfoUseCase {

    private final UserRepositoryImpl mUserRepository;

    @Inject
    UserInfoUseCase(UserRepositoryImpl userRepository) {
        mUserRepository = userRepository;
    }

    public Observable<UserInfo> loadUserInfo() {
        return mUserRepository.retrieveUserInfo();
    }
}
