package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.Group;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostya on 17.07.17.
 */

public class GroupViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_group_count)
    TextView mTvGroupCount;
    @BindView(R.id.tv_group_name)
    TextView mTvGroupName;

    public GroupViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(GroupViewHolder.this, itemView);
    }

    public void bind(Group group) {
        mTvGroupCount.setText(String.valueOf(group.getCount()));
        mTvGroupName.setText(group.getType());
    }
}
