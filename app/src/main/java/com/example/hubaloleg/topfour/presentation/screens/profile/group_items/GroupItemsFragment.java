package com.example.hubaloleg.topfour.presentation.screens.profile.group_items;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.user.Item;
import com.example.hubaloleg.topfour.presentation.screens.profile.group_items.adapter.GroupItemsAdapter;
import com.example.hubaloleg.topfour.presentation.screens.profile.group_items.view.GroupItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupItemsFragment extends MvpAppCompatFragment
        implements GroupItemView {

    private static final String ARG_ITEM_LIST = "ARG_ITEM_LIST";
    @BindView(R.id.rv_group_items)
    RecyclerView mRvGroupItems;

    GroupItemsAdapter mAdapter;
    private List<Item> mItemList = new ArrayList<>();

    public static GroupItemsFragment newInstance(ArrayList<Item> itemList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_ITEM_LIST, itemList);
        GroupItemsFragment fragment = new GroupItemsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mItemList = getArguments().getParcelableArrayList(ARG_ITEM_LIST);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_detail, container, false);
        ButterKnife.bind(GroupItemsFragment.this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        mRvGroupItems.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new GroupItemsAdapter();
        mAdapter.setItemList(mItemList);
        mRvGroupItems.setAdapter(mAdapter);
    }
}
