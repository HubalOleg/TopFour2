package com.example.hubaloleg.topfour.presentation.screens.near_venue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.presenter.NearVenuePresenter;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.view.NearVenueView;

import butterknife.ButterKnife;

public class NearVenueFragment extends MvpAppCompatFragment implements NearVenueView {
    public static final String TAG = "NearVenueFragment";

    @InjectPresenter
    NearVenuePresenter mNearVenuePresenter;

    public static NearVenueFragment newInstance() {
        NearVenueFragment fragment = new NearVenueFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @ProvidePresenter
    NearVenuePresenter providePresenter() {
        return new NearVenuePresenter();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_near_venue, container, false);

        ButterKnife.bind(NearVenueFragment.this, view);

        return view;
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
