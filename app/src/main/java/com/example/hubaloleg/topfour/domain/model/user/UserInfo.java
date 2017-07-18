package com.example.hubaloleg.topfour.domain.model.user;

import java.util.Date;
import java.util.List;

/**
 * Created by kostya on 11.07.17.
 */

public class UserInfo {
    private String mId;
    private String mUserName;
    private String mGender;
    private String mImageUrl;
    private Date mBirthdayDate;
    private String mHomeCity;
    private String mBiography;
    private List<Group> mGroupList;

    public List<Group> getGroupList() {
        return mGroupList;
    }

    public void setGroupList(List<Group> groupList) {
        mGroupList = groupList;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getBiography() {
        return mBiography;
    }

    public void setBiography(String biography) {
        mBiography = biography;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public Date getBirthdayDate() {
        return mBirthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        mBirthdayDate = birthdayDate;
    }

    public String getHomeCity() {
        return mHomeCity;
    }

    public void setHomeCity(String homeCity) {
        mHomeCity = homeCity;
    }
}
