package com.example.hubaloleg.topfour.presentation.screens.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.screens.profile.presenter.ProfilePresenter;
import com.example.hubaloleg.topfour.presentation.screens.profile.view.ProfileView;
import com.example.hubaloleg.topfour.presentation.tools.InitImageUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostya on 11.07.17.
 */

public class ProfileFragment extends MvpAppCompatFragment
        implements ProfileView {

    @InjectPresenter
    ProfilePresenter mPresenter;

    @BindView(R.id.siv_profile_image)
    ImageView mIvProfileImage;

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
        initUI();
        return view;
    }

    private void initUI() {
        InitImageUtil.intitImage(getContext(),
                "https://cdn1.iconfinder.com/data/icons/ios-7-style-metro-ui-icons/512/MetroUI_OS_Android.png",
                mIvProfileImage);
    }
}
