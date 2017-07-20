package com.example.hubaloleg.topfour.presentation.screens.profile.liked_pace_map.view;

import com.arellomobile.mvp.MvpView;
import com.example.hubaloleg.topfour.domain.model.elements.Element;

import java.util.List;

/**
 * Created by kostya on 20.07.17.
 */

public interface LikedPlaceAppView extends MvpView {

    void onError(Throwable throwable);

    void showElementList(List<Element> elements);
}
