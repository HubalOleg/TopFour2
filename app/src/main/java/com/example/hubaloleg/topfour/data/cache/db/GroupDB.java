package com.example.hubaloleg.topfour.data.cache.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kostya on 18.07.17.
 */

@Table(database = AppDatabase.class)
public class GroupDB extends BaseModel {
    @Column
    private long count;
    @Column
    private String type;
    @Column
    private String itemList;

    public List<ItemDB> getItemList() {
        Type listOfItems = new TypeToken<List<ItemDB>>(){}.getType();
        return new Gson().fromJson(itemList, listOfItems);
    }

    public void setItemList(List<ItemDB> itemList) {
        Type listOfItems = new TypeToken<List<ItemDB>>(){}.getType();
        this.itemList = new Gson().toJson(itemList, listOfItems);
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
