package com.example.hubaloleg.topfour.data.remote.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kostya on 20.07.17.
 */

public class TagEntity {
    @SerializedName("abutters")
    private String abutters;
    @SerializedName("highway")
    private String highway;
    @SerializedName("int_ref")
    private String intRef;
    @SerializedName("lanes")
    private long lanes;
    @SerializedName("maxspeed")
    private String maxSpeed;
    @SerializedName("old_ref")
    private String oldRef;
    @SerializedName("ref")
    private String ref;
    @SerializedName("surface")
    private String surface;

    public String getAbutters() {
        return abutters;
    }

    public void setAbutters(String abutters) {
        this.abutters = abutters;
    }

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getIntRef() {
        return intRef;
    }

    public void setIntRef(String intRef) {
        this.intRef = intRef;
    }

    public long getLanes() {
        return lanes;
    }

    public void setLanes(long lanes) {
        this.lanes = lanes;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getOldRef() {
        return oldRef;
    }

    public void setOldRef(String oldRef) {
        this.oldRef = oldRef;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }
}
