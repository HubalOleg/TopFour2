package com.example.hubaloleg.topfour.presentation.screens.profile.group_items.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.user.Item;

import java.util.List;

public class GroupItemsAdapter extends RecyclerView.Adapter<GroupItemsViewHolder> {


    private List<Item> mItemList;

    @Override
    public GroupItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_items, parent, false);
        return new GroupItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupItemsViewHolder holder, int position) {
        holder.bind(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public void setItemList(List<Item> itemList) {
        mItemList = itemList;
    }
}
