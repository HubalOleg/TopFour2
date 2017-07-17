package com.example.hubaloleg.topfour.data.remote.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostya on 17.07.17.
 */

public class SingleGroupEntity {
    @SerializedName("items")
    private List<ItemEntity> mListItemEntities;
    @SerializedName("type")
    private String type;
    @SerializedName("count")
    private long count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<ItemEntity> getListItemEntities() {
        return mListItemEntities;
    }

    public void setListItemEntities(List<ItemEntity> listItemEntities) {
        mListItemEntities = listItemEntities;
    }
}
