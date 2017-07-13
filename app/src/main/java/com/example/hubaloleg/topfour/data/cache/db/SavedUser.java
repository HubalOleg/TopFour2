package com.example.hubaloleg.topfour.data.cache.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

import static com.raizlabs.android.dbflow.annotation.ConflictAction.REPLACE;

/**
 * Created by kostya on 13.07.17.
 */

public class SavedUser extends BaseModel {
    @PrimaryKey(autoincrement = true)
    @Column
    private long id;
    @Column
    @Unique(onUniqueConflict = REPLACE)
    private String userID;
    @Column
    private String userName;
    @Column
    private String userCity;
    @Column
    private String userPhotoURL;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPhotoURL() {
        return userPhotoURL;
    }

    public void setUserPhotoURL(String userPhotoURL) {
        this.userPhotoURL = userPhotoURL;
    }
}
