package com.example.hubaloleg.topfour.data.mapper.user;

import com.example.hubaloleg.topfour.data.remote.model.entity.user.GroupEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.user.ItemEntity;
import com.example.hubaloleg.topfour.domain.model.user.Group;
import com.example.hubaloleg.topfour.domain.model.user.Item;

import java.util.ArrayList;
import java.util.List;

public class GroupMapper {
    public List<Group> transformGroupList(List<GroupEntity> groupEntities) {
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

    private ArrayList<Item> transformItemEntity(List<ItemEntity> listItemEntities) {
        ArrayList<Item> itemList = new ArrayList<>();
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
