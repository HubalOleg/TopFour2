package com.example.hubaloleg.topfour.data.mapper;

import com.example.hubaloleg.topfour.data.remote.model.entity.ItemEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.SingleGroupEntity;
import com.example.hubaloleg.topfour.domain.model.Item;
import com.example.hubaloleg.topfour.domain.model.SingleGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostya on 17.07.17.
 */

public class GroupMapper {

    public List<SingleGroup> transform(List<SingleGroupEntity> singleGroupEntity) {
        List<SingleGroup> singleGroupList = new ArrayList<>();
        for (SingleGroupEntity entity : singleGroupEntity)
            singleGroupList.add(transformApi(entity));
        return singleGroupList;
    }

    private SingleGroup transformApi(SingleGroupEntity entity) {
        SingleGroup singleGroup = new SingleGroup();
        singleGroup.setCount(entity.getCount());
        singleGroup.setType(entity.getType());
        singleGroup.setItemList(transformItemList(entity.getListItemEntities()));
        return singleGroup;
    }

    private List<Item> transformItemList(List<ItemEntity> listItemEntities) {
        List<Item> itemList = new ArrayList<>();
        for (ItemEntity itemEntity : listItemEntities)
            itemList.add(transformSingleItemEntity(itemEntity));
        return itemList;
    }

    private Item transformSingleItemEntity(ItemEntity entity) {
        Item item = new Item();
        item.setType(entity.getType());
        item.setCanonicalUrl(entity.getCanonicalUrl());
        item.setId(entity.getId());
        item.setName(entity.getName());
        return item;
    }
}
