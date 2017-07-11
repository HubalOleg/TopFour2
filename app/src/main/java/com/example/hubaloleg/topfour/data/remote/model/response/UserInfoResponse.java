package com.example.hubaloleg.topfour.data.remote.model.response;

import com.example.hubaloleg.topfour.data.remote.model.entity.UserEntity;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kostya on 11.07.17.
 */

public class UserInfoResponse {
    @SerializedName("user")
    private UserEntity mUserEntity;
}
