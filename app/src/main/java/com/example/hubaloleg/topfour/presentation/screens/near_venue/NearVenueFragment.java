package com.example.hubaloleg.topfour.presentation.screens.near_venue;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.Venue;
import com.example.hubaloleg.topfour.presentation.adapter.VenueAdapter;
import com.example.hubaloleg.topfour.presentation.di.components.DaggerVenueComponent;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.presenter.NearVenuePresenter;
import com.example.hubaloleg.topfour.presentation.screens.near_venue.view.NearVenueView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NearVenueFragment extends MvpAppCompatFragment implements NearVenueView {
    public static final String TAG = "NearVenueFragment";

    VenueAdapter mVenueAdapter;

    @BindView(R.id.rv_venue)
    RecyclerView mVenueRecyclerView;
    @BindView(R.id.iv_profile_image)
    ImageView mProfileImageView;
    @BindView(R.id.fab_search_location)
    FloatingActionButton mSearchLocationFAB;
    @BindView(R.id.pb_loading)
    ProgressBar mLoadingProgressBar;

    @Inject
    @InjectPresenter
    NearVenuePresenter mNearVenuePresenter;

    @ProvidePresenter
    NearVenuePresenter providePresenter() {
        initInjection();
        return mNearVenuePresenter;
    }

    private void initInjection() {
        DaggerVenueComponent.builder()
                .appComponent(TopFourApplication.getAppComponent())
                .build()
                .inject(NearVenueFragment.this);
    }

    public static NearVenueFragment newInstance() {
        NearVenueFragment fragment = new NearVenueFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mVenueRecyclerView.setLayoutManager(linearLayoutManager);

        mVenueAdapter = new VenueAdapter();
        mVenueRecyclerView.setAdapter(mVenueAdapter);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @OnClick(R.id.fab_search_location)
    public void onSearchLocationClick() {
        mNearVenuePresenter.onSearchVenuesClick("");
    }

    @Override
    public void showVenues(List<Venue> venueList) {
        mVenueAdapter.updateVenues(venueList);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        mLoadingProgressBar.setVisibility(View.GONE);
    }
}
