package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view;

import com.arellomobile.mvp.MvpView;
import com.example.hubaloleg.topfour.domain.model.UserInfo;

public interface ProfileView extends MvpView {
    void showUserInfo(UserInfo userInfo);

    void userFetchFailure(Throwable throwable);
}
