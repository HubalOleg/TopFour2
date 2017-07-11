package com.example.hubaloleg.topfour.presentation.screens.near_venue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.di.component.DaggerRepositoryComponent;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.presenter.NearVenuePresenter;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.view.NearVenueView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NearVenueFragment extends MvpAppCompatFragment implements NearVenueView {
    public static final String TAG = "NearVenueFragment";

    @BindView(R.id.iv_profile_image)
    ImageView mProfileImageView;

    @Inject
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
        initInjection();
        return new NearVenuePresenter();
    }

    private void initInjection() {
        DaggerRepositoryComponent.builder()
                .appComponent(TopFourApplication.getAppComponent())
                .build()
                .inject(NearVenueFragment.this);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_near_venue, container, false);
        ButterKnife.bind(NearVenueFragment.this, view);
        initViews();
        return view;
    }

    private void initViews() {
        mProfileImageView.setImageResource(R.drawable.ic_profile);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
