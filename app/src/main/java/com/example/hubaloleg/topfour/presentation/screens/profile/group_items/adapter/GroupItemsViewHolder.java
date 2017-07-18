package com.example.hubaloleg.topfour.presentation.screens.profile.group_items.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.Item;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupItemsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_item_group_description)
    TextView mTvGroupDescription;
    @BindView(R.id.tv_item_group_name)
    TextView mTvItemGroupName;

    public GroupItemsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(GroupItemsViewHolder.this, itemView);
    }

    public void bind(Item item) {
        mTvItemGroupName.setText(item.getName());
    }
}
