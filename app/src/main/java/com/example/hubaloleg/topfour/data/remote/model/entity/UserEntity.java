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
}
