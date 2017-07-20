package com.example.hubaloleg.topfour.data.remote.model.response;

import com.example.hubaloleg.topfour.data.remote.model.entity.ElementsEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kostya on 20.07.17.
 */

public class MaxSpeedResponse {
    @SerializedName("elements")
    private List<ElementsEntity> mElementsEntityList;

    public List<ElementsEntity> getElementsEntityList() {
        return mElementsEntityList;
    }

    public void setElementsEntityList(List<ElementsEntity> elementsEntityList) {
        mElementsEntityList = elementsEntityList;
    }
}
