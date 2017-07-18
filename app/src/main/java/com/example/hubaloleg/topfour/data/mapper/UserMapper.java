package com.example.hubaloleg.topfour.data.mapper;

import android.support.annotation.NonNull;

import com.example.hubaloleg.topfour.data.cache.db.UserDB;
import com.example.hubaloleg.topfour.data.remote.model.entity.GroupEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.ItemEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;
import com.example.hubaloleg.topfour.domain.model.Group;
import com.example.hubaloleg.topfour.domain.model.Item;
import com.example.hubaloleg.topfour.domain.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public UserInfo transform(UserDB userDB) {
        UserInfo userInfo = new UserInfo();
        if (userDB != null) {
            userInfo.setUserName(userDB.getUserName());
            userInfo.setHomeCity(userDB.getUserCity());
            userInfo.setImageUrl(userDB.getUserPhotoURL());
            userInfo.setId(userDB.getUserID());
            userInfo.setBiography(userDB.getUserBiography());
            userInfo.setGroupList(transformGroupList(userDB.getGroupEntityList()));
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

    private List<Group> transformGroupList(List<GroupEntity> groupEntities) {
        List<Group> groupList = new ArrayList<>();
        for (GroupEntity groupEntity : groupEntities)
            groupList.add(transformGroup(groupEntity));
        return groupList;
    }

    private Group transformGroup(GroupEntity groupEntity) {
        Group group = new Group();
        group.setCount(groupEntity.getCount());
        group.setType(groupEntity.getType());
        group.setItemList(transformItemEntity(groupEntity.getListItemEntities()));
        return group;
    }

    private List<Item> transformItemEntity(List<ItemEntity> listItemEntities) {
        List<Item> itemList = new ArrayList<>();
        for (ItemEntity itemEntity : listItemEntities) {
            itemList.add(transformItem(itemEntity));
        }
        return itemList;
    }

    private Item transformItem(ItemEntity itemEntity) {
        Item item = new Item();
        item.setName(itemEntity.getName());
        item.setId(itemEntity.getId());
        item.setType(itemEntity.getType());
        item.setCanonicalUrl(itemEntity.getCanonicalUrl());
        return item;
    }
}
