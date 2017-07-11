package com.example.hubaloleg.topfour.presentation.screens.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.hubaloleg.topfour.R;

import butterknife.ButterKnife;

/**
 * Created by kostya on 11.07.17.
 */

public class ProfileFragment extends MvpAppCompatFragment {

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
        return view;
    }
}
