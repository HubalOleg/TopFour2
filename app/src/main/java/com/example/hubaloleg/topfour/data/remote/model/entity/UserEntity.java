package com.example.hubaloleg.topfour.data.remote.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kostya on 11.07.17.
 */

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
