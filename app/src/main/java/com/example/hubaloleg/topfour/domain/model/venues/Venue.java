package com.example.hubaloleg.topfour.domain.model.venues;

import java.util.List;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class Venue {

    private String mId;
    private String mName;
    private List<Category> mCategoryList;

    public Venue() {

    }

    public Venue(String id, String name, List<Category> categoryList) {
        mId = id;
        mName = name;
        mCategoryList = categoryList;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public List<Category> getCategoryList() {
        return mCategoryList;
    }
}
