package com.example.hubaloleg.topfour.data.cache.db;

import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.annotation.ManyToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hubaloleg on 12.07.17.
 */

@Table(database = AppDatabase.class)
@ManyToMany(referencedTable = CategoryDB.class)
public class VenueDB extends BaseModel {

    @Column
    @PrimaryKey
    private String id;
    @Column
    private String name;
    @ColumnIgnore
    List<CategoryDB> categoryDBList;

    public List<CategoryDB> getCategoryDBList() {
        if (categoryDBList == null) {
            List<VenueDB_CategoryDB> venueCategoryRelation = SQLite.select()
                    .from(VenueDB_CategoryDB.class)
                    .where(VenueDB_CategoryDB_Table.venueDB_id.eq(id))
                    .queryList();
            categoryDBList = new ArrayList<>();
            for (VenueDB_CategoryDB venueDB_categoryDB : venueCategoryRelation) {
                categoryDBList.add(venueDB_categoryDB.categoryDB);
            }
        }
        return categoryDBList;
    }

    public VenueDB() {
    }

    public VenueDB(String id, String name, List<CategoryDB> categoryDBList) {
        this.id = id;
        this.name = name;
        this.categoryDBList = categoryDBList;
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

    public void setCategoryDBList(List<CategoryDB> categoryDBList) {
        this.categoryDBList = categoryDBList;
    }

    @Override
    public boolean save() {
        saveCategories();
        return super.save();
    }

    @Override
    public boolean save(@NonNull DatabaseWrapper databaseWrapper) {
        saveCategories();
        return super.save(databaseWrapper);
    }

    private void saveCategories() {
        for (CategoryDB categoryDB : categoryDBList) {
            categoryDB.save();
        }
//        FlowManager.getDatabase(AppDatabase.class).executeTransaction(
//                FastStoreModelTransaction
//                        .insertBuilder(FlowManager.getModelAdapter(CategoryDB.class))
//                        .addAll(categoryDBList)
//                        .build());
    }
}
