package com.example.hubaloleg.topfour.domain.usecase;

import com.example.hubaloleg.topfour.domain.model.user.UserInfo;
import com.example.hubaloleg.topfour.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UserInfoUseCase {

    private final UserRepository mUserRepository;

    @Inject
    UserInfoUseCase(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    public Observable<UserInfo> loadUserInfo() {
        return mUserRepository.retrieveUserInfo();
    }

}
