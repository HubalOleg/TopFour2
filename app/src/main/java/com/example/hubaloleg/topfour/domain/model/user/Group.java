package com.example.hubaloleg.topfour.domain.model.user;

import java.util.ArrayList;

/**
 * Created by kostya on 17.07.17.
 */

public class Group {
    private ArrayList<Item> mItemList;
    private String type;
    private long count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public ArrayList<Item> getItemList() {
        return mItemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        mItemList = itemList;
    }
}
