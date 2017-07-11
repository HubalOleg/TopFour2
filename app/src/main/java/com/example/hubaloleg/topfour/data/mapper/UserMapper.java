package com.example.hubaloleg.topfour.data.mapper;

import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;
import com.example.hubaloleg.topfour.domain.model.UserInfo;

import java.util.Date;

/**
 * Created by kostya on 11.07.17.
 */

public class UserMapper {

    public UserInfo transform(UserEntity userEntity) {
        UserInfo userInfo = new UserInfo();
        if (userEntity != null) {
            userInfo.setBiography(userEntity.getBiography());
            userInfo.setFirstName(userEntity.getFirstName());
            userInfo.setLastName(userEntity.getLastName());
            userInfo.setBirthdayDate(new Date(userEntity.getBirthdayTimestamp()));
            userInfo.setGender(userEntity.getGender());
            userInfo.setHomeCity(userEntity.getHomeCity());
            userInfo.setImageUrl(getImageUrl(userEntity.getIconEntity()));
            userInfo.setId(userEntity.getUserId());
        }
        return userInfo;
    }

    private String getImageUrl(IconEntity iconEntity) {
        return iconEntity.getPrefix() + "200x200" + iconEntity.getSuffix();
    }
}
