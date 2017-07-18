package com.example.hubaloleg.topfour.data.remote.model.entity.venues;

import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class CategoryEntity {
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("icon")
    private IconEntity mIconEntity;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public IconEntity getIconEntity() {
        return mIconEntity;
    }

    public void setIconEntity(IconEntity iconEntity) {
        mIconEntity = iconEntity;
    }
}
