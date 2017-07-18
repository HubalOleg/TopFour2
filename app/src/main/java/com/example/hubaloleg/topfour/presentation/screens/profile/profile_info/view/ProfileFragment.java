package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.Group;
import com.example.hubaloleg.topfour.domain.model.Item;
import com.example.hubaloleg.topfour.domain.model.UserInfo;
import com.example.hubaloleg.topfour.presentation.di.components.DaggerUserInfoComponent;
import com.example.hubaloleg.topfour.presentation.global.TopFourApplication;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter.GroupAdapter;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter.GroupViewHolder;
import com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.presenter.ProfilePresenter;
import com.example.hubaloleg.topfour.presentation.tools.InfoMessageUtil;
import com.example.hubaloleg.topfour.presentation.tools.InitImageUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends MvpAppCompatFragment
        implements ProfileView {

    private static final String TAG = ProfileFragment.class.getSimpleName();
    public static final int SPAN_COUNT = 1;

    @InjectPresenter
    @Inject
    ProfilePresenter mPresenter;

    @BindView(R.id.siv_profile_image)
    ImageView mIvProfileImage;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.rv_lists)
    RecyclerView mRvLists;

    private GroupAdapter mGroupAdapter;
    private OnProfileFragmentInteractionListener mListener;
    private List<Group> mGroupList = new ArrayList<>();

    @ProvidePresenter
    ProfilePresenter provideProfilePresenter() {
        initInjection();
        return mPresenter;
    }

    //region listener

    private GroupViewHolder.OnGroupViewHolderClickListener mOnGroupViewHolderClickListener = adapterPosition ->
            mListener.onGroupClick(mGroupList.get(adapterPosition).getItemList());

    //endregion listener end

    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = ((OnProfileFragmentInteractionListener) context);
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + " must implement OnProfileFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(ProfileFragment.this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        mRvLists.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT, LinearLayoutManager.HORIZONTAL, false));
        mGroupAdapter = new GroupAdapter(mOnGroupViewHolderClickListener);
        mRvLists.setAdapter(mGroupAdapter);
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        Log.d(TAG, "showUserInfo: " + userInfo);
        initUserInfo(userInfo);
        showUserGroups(userInfo.getGroupList());
    }

    private void showUserGroups(List<Group> groupList) {
        mGroupList.clear();
        mGroupList = groupList;
        mGroupAdapter.setGroupList(mGroupList);
    }

    @Override
    public void userFetchFailure(Throwable throwable) {
        Log.d(TAG, "userFetchFailure: " + throwable.toString());
        InfoMessageUtil.showMessage(getContext(), getString(R.string.error_user_fetch_failed));
    }

    private void initInjection() {
        DaggerUserInfoComponent
                .builder()
                .appComponent(TopFourApplication.getAppComponent())
                .build()
                .inject(ProfileFragment.this);
    }


    private void initUserInfo(UserInfo userInfo) {
        InitImageUtil.intitImage(getContext(), userInfo.getImageUrl(), mIvProfileImage);
        mCollapsingToolbarLayout.setTitle(userInfo.getUserName());
    }

    // interface
    public interface OnProfileFragmentInteractionListener {
        void onGroupClick(ArrayList<Item> itemList);
    }
}
