package com.example.hubaloleg.topfour.data.remote.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostya on 18.07.17.
 */

public class ListEntity {
    @SerializedName("count")
    private long count;
    @SerializedName("groups")
    private List<GroupEntity> mGroupEntityList;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<GroupEntity> getGroupEntityList() {
        return mGroupEntityList;
    }

    public void setGroupEntityList(List<GroupEntity> groupEntityList) {
        mGroupEntityList = groupEntityList;
    }
}
