package com.example.hubaloleg.topfour.domain.model;

import java.util.List;

/**
 * Created by kostya on 17.07.17.
 */

public class Group {
    private List<SingleGroup> mSingleGroupList;

    public List<SingleGroup> getSingleGroupList() {
        return mSingleGroupList;
    }

    public void setSingleGroupList(List<SingleGroup> singleGroupList) {
        mSingleGroupList = singleGroupList;
    }
}
