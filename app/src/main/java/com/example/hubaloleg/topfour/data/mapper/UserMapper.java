package com.example.hubaloleg.topfour.data.mapper;

import android.support.annotation.NonNull;

import com.example.hubaloleg.topfour.data.cache.db.SavedUser;
import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;
import com.example.hubaloleg.topfour.domain.model.UserInfo;

import java.util.Date;

/**
 * Created by kostya on 11.07.17.
 */

public class UserMapper {

    public UserInfo transform(SavedUser userEntity) {
        UserInfo userInfo = new UserInfo();
        if (userEntity != null) {
            userInfo.setUserName(userEntity.getUserName());
            userInfo.setHomeCity(userEntity.getUserCity());
            userInfo.setImageUrl(userEntity.getUserPhotoURL());
            userInfo.setId(userEntity.getUserID());
        }
        return userInfo;
    }

    public SavedUser transformToDB(UserEntity userEntity) {
        SavedUser savedUser = new SavedUser();
        savedUser.setUserCity(userEntity.getHomeCity());
        savedUser.setUserID(userEntity.getUserId());
        savedUser.setUserPhotoURL(getImageUrl(userEntity.getIconEntity()));
        savedUser.setUserName(getUserName(userEntity));
        return savedUser;
    }

    @NonNull
    private String getUserName(UserEntity userEntity) {
        return userEntity.getFirstName() + " " + userEntity.getLastName();
    }

    private String getImageUrl(IconEntity iconEntity) {
        return iconEntity.getPrefix() + "original" + iconEntity.getSuffix();
    }
}
