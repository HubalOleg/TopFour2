package com.example.hubaloleg.topfour.data.remote.model.entity.user;

import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.google.gson.annotations.SerializedName;

public class UserEntity {
    @SerializedName("id")
    private String mUserId;
    @SerializedName("firstName")
    private String mFirstName;
    @SerializedName("lastName")
    private String mLastName;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("photo")
    private IconEntity mIconEntity;
    @SerializedName("birthday")
    private long mBirthdayTimestamp;
    @SerializedName("homeCity")
    private String mHomeCity;
    @SerializedName("bio")
    private String mBiography;
    @SerializedName("lists")
    private ListEntity mListEntity;

    public ListEntity getListEntity() {
        return mListEntity;
    }

    public void setListEntity(ListEntity listEntity) {
        mListEntity = listEntity;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public IconEntity getIconEntity() {
        return mIconEntity;
    }

    public void setIconEntity(IconEntity iconEntity) {
        mIconEntity = iconEntity;
    }

    public long getBirthdayTimestamp() {
        return mBirthdayTimestamp;
    }

    public void setBirthdayTimestamp(long birthdayTimestamp) {
        mBirthdayTimestamp = birthdayTimestamp;
    }

    public String getHomeCity() {
        return mHomeCity;
    }

    public void setHomeCity(String homeCity) {
        mHomeCity = homeCity;
    }

    public String getBiography() {
        return mBiography;
    }

    public void setBiography(String biography) {
        mBiography = biography;
    }
}
