package com.example.hubaloleg.topfour.data.remote.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kostya on 20.07.17.
 */

public class ElementsEntity {
    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("tags")
    private TagEntity mTagEntity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TagEntity getTagEntity() {
        return mTagEntity;
    }

    public void setTagEntity(TagEntity tagEntity) {
        mTagEntity = tagEntity;
    }
}
