package com.example.hubaloleg.topfour.data.cache.db;

import com.example.hubaloleg.topfour.data.remote.model.entity.GroupEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.lang.reflect.Type;
import java.util.List;

import static com.raizlabs.android.dbflow.annotation.ConflictAction.REPLACE;

@Table(database = AppDatabase.class)
public class UserDB extends BaseModel {
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
    @Column
    private String userBiography;
    @Column
    String groupEntityList;

    public List<GroupEntity> getGroupEntityList() {
        Type listOfItems = new TypeToken<List<GroupEntity>>(){}.getType();
        return new Gson().fromJson(groupEntityList, listOfItems);
    }

    public void setGroupEntityList(List<GroupEntity> groupEntityList) {
        Type listOfItems = new TypeToken<List<GroupEntity>>(){}.getType();
        this.groupEntityList = new Gson().toJson(groupEntityList, listOfItems);
    }

    public long getId() {
        return id;
    }

    public String getUserBiography() {
        return userBiography;
    }

    public void setUserBiography(String userBiography) {
        this.userBiography = userBiography;
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
