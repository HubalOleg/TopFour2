package com.example.hubaloleg.topfour.data.cache.db;

import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

/**
 * Created by hubaloleg on 14.07.17.
 */

@Table(database = AppDatabase.class)
public class CategoryDB extends BaseModel {

    @PrimaryKey
    private String id;
    @Column
    private String name;
    @ForeignKey(saveForeignKeyModel = true)
    private IconDB iconDB;

    public CategoryDB() {

    }

    public CategoryDB(String id, String name, IconDB iconDB) {
        this.id = id;
        this.name = name;
        this.iconDB = iconDB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IconDB getIconDB() {
        return iconDB;
    }

    public void setIconDB(IconDB iconDB) {
        this.iconDB = iconDB;
    }

    @Override
    public boolean save() {
        return super.save();
    }

    @Override
    public boolean save(@NonNull DatabaseWrapper databaseWrapper) {
        return super.save(databaseWrapper);
    }
}
