package com.example.hubaloleg.topfour.domain.model;

import java.util.Date;

/**
 * Created by kostya on 11.07.17.
 */

public class UserInfo {
    private String mId;
    private String mFirstName;
    private String mLastName;
    private String mGender;
    private String mImageUrl;
    private Date mBirthdayDate;
    private String mHomeCity;
    private String mBiography;

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
