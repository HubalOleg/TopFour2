package com.example.hubaloleg.topfour.data.remote.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class ResponseBody<T> {

    @SerializedName("response")
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
