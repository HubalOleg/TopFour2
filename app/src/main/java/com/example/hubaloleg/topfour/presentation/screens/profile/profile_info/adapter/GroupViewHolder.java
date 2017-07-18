package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.Group;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kostya on 17.07.17.
 */

public class GroupViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_group_count)
    TextView mTvGroupCount;
    @BindView(R.id.tv_group_name)
    TextView mTvGroupName;

    private OnGroupViewHolderClickListener mListener;

    public GroupViewHolder(View itemView, OnGroupViewHolderClickListener listener) {
        super(itemView);
        mListener = listener;
        ButterKnife.bind(GroupViewHolder.this, itemView);
    }

    @OnClick(R.id.rl_item_lists)
    public void onItemClick() {
        mListener.onItemClick(getAdapterPosition());
    }

    public void bind(Group group) {
        mTvGroupCount.setText(String.valueOf(group.getCount()));
        mTvGroupName.setText(group.getType());
    }

    //interface
    public interface OnGroupViewHolderClickListener {
        void onItemClick(int adapterPosition);
    }
}
