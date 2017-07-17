package com.example.hubaloleg.topfour.presentation.screens.profile.user_lists;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.hubaloleg.topfour.R;

import butterknife.ButterKnife;

/**
 * Created by kostya on 17.07.17.
 */

public class UserListsFragment extends MvpAppCompatFragment {

    public static UserListsFragment newInstance() {
        Bundle args = new Bundle();
        UserListsFragment fragment = new UserListsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_lists, container, false);
        ButterKnife.bind(UserListsFragment.this, view);
        return view;
    }
}
