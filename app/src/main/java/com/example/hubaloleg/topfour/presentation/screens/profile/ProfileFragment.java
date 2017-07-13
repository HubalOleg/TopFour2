package com.example.hubaloleg.topfour.presentation.screens.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.presentation.di.components.DaggerUserInfoComponent;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.profile.presenter.ProfilePresenter;
import com.example.hubaloleg.topfour.presentation.screens.profile.view.ProfileView;
import com.example.hubaloleg.topfour.presentation.tools.InitImageUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostya on 11.07.17.
 */

public class ProfileFragment extends MvpAppCompatFragment
        implements ProfileView {

    public static final String TEST_IMAGE = "https://cdn1.iconfinder.com/data/icons/ios-7-style-metro-ui-icons/512/MetroUI_OS_Android.png";
    private static final String TAG = ProfileFragment.class.getSimpleName();

    @InjectPresenter
    @Inject
    ProfilePresenter mPresenter;

    @BindView(R.id.siv_profile_image)
    ImageView mIvProfileImage;
//    @BindView(R.id.rv_venue_history)
//    RecyclerView mRvVenueHistory;
//    @BindView(R.id.rv_lists)
//    RecyclerView mRvLists;
//    @BindView(R.id.tv_user_name)
//    TextView mTvUserName;
//    @BindView(R.id.tv_user_city)
//    TextView mTvUserCity;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;


    @ProvidePresenter
    ProfilePresenter provideProfilePresenter() {
        initInjection();
        return mPresenter;
    }

    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(ProfileFragment.this, view);
        loadProfileData();
        return view;
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        Log.d(TAG, "showUserInfo: " + userInfo);
        initUserInfo(userInfo);
    }

    private void initInjection() {
        DaggerUserInfoComponent
                .builder()
                .appComponent(TopFourApplication.getAppComponent())
                .build()
                .inject(ProfileFragment.this);
    }

    private void loadProfileData() {
        mPresenter.loadUserData();
    }

    private void initUserInfo(UserInfo userInfo) {
        InitImageUtil.intitImage(getContext(), userInfo.getImageUrl(), mIvProfileImage);
        mCollapsingToolbarLayout.setTitle(userInfo.getUserName());
    }
}
