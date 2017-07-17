package com.example.hubaloleg.topfour.data.remote.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostya on 17.07.17.
 */

public class GroupEntity {
    @SerializedName("groups")
    private List<SingleGroupEntity> mSingleGroupEntities;

    public List<SingleGroupEntity> getSingleGroupEntities() {
        return mSingleGroupEntities;
    }

    public void setSingleGroupEntities(List<SingleGroupEntity> singleGroupEntities) {
        mSingleGroupEntities = singleGroupEntities;
    }
}
