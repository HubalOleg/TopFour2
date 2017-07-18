package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostya on 17.07.17.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupViewHolder> {
    private List<Group> mGroupList = new ArrayList<>();

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lists, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        holder.bind(mGroupList.get(position));
    }

    @Override
    public int getItemCount() {
        return mGroupList.size();
    }

    public void setGroupList(List<Group> groupList) {
        mGroupList = groupList;
        notifyDataSetChanged();
    }
}
