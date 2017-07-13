package com.example.hubaloleg.topfour.data.cache.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by hubaloleg on 12.07.17.
 */

@Table(database = AppDatabase.class)
public class VenueDB extends BaseModel {

    @Column
    @PrimaryKey
    private String id;
    @Column
    private String name;

    public VenueDB() {

    }

    public VenueDB(String id, String name) {
        this.id = id;
        this.name = name;
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
}
