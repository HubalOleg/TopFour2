package com.example.hubaloleg.topfour.data.remote.model.entity.venues;

import com.example.hubaloleg.topfour.data.remote.model.entity.user.ItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class VenueEntity {

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("categories")
    private List<CategoryEntity> mCategoryEntityList;
    @SerializedName("items")
    private List<ItemEntity> mItemEntityList;

    public List<ItemEntity> getItemEntityList() {
        return mItemEntityList;
    }

    public void setItemEntityList(List<ItemEntity> itemEntityList) {
        mItemEntityList = itemEntityList;
    }

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

    public List<CategoryEntity> getCategoryEntityList() {
        return mCategoryEntityList;
    }

    public void setCategoryEntityList(List<CategoryEntity> categoryEntityList) {
        mCategoryEntityList = categoryEntityList;
    }
}
