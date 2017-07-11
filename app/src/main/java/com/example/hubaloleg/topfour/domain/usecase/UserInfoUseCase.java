package com.example.hubaloleg.topfour.domain.usecase;

import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by kostya on 11.07.17.
 */

public class UserInfoUseCase {

    private final UserRepository mUserRepository;

    @Inject
    UserInfoUseCase(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    public Observable<UserInfo> loadUserInfo(String token) {
        return mUserRepository.retrieveUserInfo(token);
    }
}
