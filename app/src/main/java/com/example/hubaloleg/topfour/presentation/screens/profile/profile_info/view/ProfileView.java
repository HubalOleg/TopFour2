package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view;

import com.arellomobile.mvp.MvpView;
import com.example.hubaloleg.topfour.domain.model.user.UserInfo;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;

import java.util.List;

public interface ProfileView extends MvpView {
    void showUserInfo(UserInfo userInfo);

    void userFetchFailure(Throwable throwable);

    void likedVenueFetchFailure(Throwable throwable);

    void showLikedVenueList(List<LikedVenue> likedVenues);
}
