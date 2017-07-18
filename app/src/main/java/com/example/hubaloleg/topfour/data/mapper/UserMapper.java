package com.example.hubaloleg.topfour.data.mapper;

import android.support.annotation.NonNull;

import com.example.hubaloleg.topfour.data.cache.db.UserDB;
import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;
import com.example.hubaloleg.topfour.domain.model.UserInfo;

import javax.inject.Inject;

public class UserMapper {

    private final GroupMapper mGroupMapper;

    @Inject
    public UserMapper(GroupMapper groupMapper) {
        mGroupMapper = groupMapper;
    }

    public UserInfo transform(UserDB userDB) {
        UserInfo userInfo = new UserInfo();
        if (userDB != null) {
            userInfo.setUserName(userDB.getUserName());
            userInfo.setHomeCity(userDB.getUserCity());
            userInfo.setImageUrl(userDB.getUserPhotoURL());
            userInfo.setId(userDB.getUserID());
            userInfo.setBiography(userDB.getUserBiography());
            userInfo.setGroupList(mGroupMapper.transformGroupList(userDB.getGroupEntityList()));
        }
        return userInfo;
    }


    public UserDB transformToDB(UserEntity userEntity) {
        UserDB userDB = new UserDB();
        userDB.setUserCity(userEntity.getHomeCity());
        userDB.setUserID(userEntity.getUserId());
        userDB.setUserPhotoURL(getImageUrl(userEntity.getIconEntity()));
        userDB.setUserName(getUserName(userEntity));
        userDB.setUserBiography(userEntity.getBiography());
        userDB.setGroupEntityList(userEntity.getListEntity().getGroupEntityList());
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
