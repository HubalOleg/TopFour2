package com.example.hubaloleg.topfour.data.mapper;

import android.support.annotation.NonNull;

import com.example.hubaloleg.topfour.data.cache.db.UserDB;
import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;
import com.example.hubaloleg.topfour.domain.model.UserInfo;

/**
 * Created by kostya on 11.07.17.
 */

public class UserMapper {

    public UserInfo transform(UserDB userEntity) {
        UserInfo userInfo = new UserInfo();
        if (userEntity != null) {
            userInfo.setUserName(userEntity.getUserName());
            userInfo.setHomeCity(userEntity.getUserCity());
            userInfo.setImageUrl(userEntity.getUserPhotoURL());
            userInfo.setId(userEntity.getUserID());
        }
        return userInfo;
    }

    public UserDB transformToDB(UserEntity userEntity) {
        UserDB userDB = new UserDB();
        userDB.setUserCity(userEntity.getHomeCity());
        userDB.setUserID(userEntity.getUserId());
        userDB.setUserPhotoURL(getImageUrl(userEntity.getIconEntity()));
        userDB.setUserName(getUserName(userEntity));
        return userDB;
    }

    @NonNull
    private String getUserName(UserEntity userEntity) {
        return userEntity.getFirstName() + " " + userEntity.getLastName();
    }

    private String getImageUrl(IconEntity iconEntity) {
        return iconEntity.getPrefix() + "original" + iconEntity.getSuffix();
    }
}
