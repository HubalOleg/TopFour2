package com.example.hubaloleg.topfour.domain.model;

/**
 * Created by hubaloleg on 12.07.17.
 */

public class Category {
    private String mId;
    private String mName;
    private Icon mIcon;

    public Category() {
    }

    public Category(String id, String name, Icon icon) {
        mId = id;
        mName = name;
        mIcon = icon;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public Icon getIcon() {
        return mIcon;
    }
}
