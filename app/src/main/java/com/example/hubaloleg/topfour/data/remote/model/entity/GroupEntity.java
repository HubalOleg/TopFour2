package com.example.hubaloleg.topfour.data.remote.model.entity;

import com.example.hubaloleg.topfour.data.remote.model.entity.SingleGroupEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostya on 17.07.17.
 */

public class GroupEntity {
    @SerializedName("groups")
    private List<SingleGroupEntity> mSingleGroupEntityList;

    public List<SingleGroupEntity> getSingleGroupEntityList() {
        return mSingleGroupEntityList;
    }

    public void setSingleGroupEntityList(List<SingleGroupEntity> singleGroupEntityList) {
        mSingleGroupEntityList = singleGroupEntityList;
    }
}
