package com.example.hubaloleg.topfour.data.cache.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by hubaloleg on 12.07.17.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    public static final String NAME = "TopFourDatabase";
    public static final int VERSION = 1;
}
