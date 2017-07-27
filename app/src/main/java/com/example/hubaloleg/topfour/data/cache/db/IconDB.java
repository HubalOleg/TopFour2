package com.example.hubaloleg.topfour.data.cache.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by hubaloleg on 14.07.17.
 */

@Table(database = AppDatabase.class)
public class IconDB extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    private int id;
    @Column
    private String prefix;
    @Column
    private String suffix;

    public IconDB() {

    }

    public IconDB(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
