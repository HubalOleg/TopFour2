package com.example.hubaloleg.topfour.domain.model.user;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kostya on 17.07.17.
 */

public class Item implements Parcelable {
    private String id;
    private String name;
    private String type;
    private String canonicalUrl;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.canonicalUrl);
    }

    public Item() {
    }

    protected Item(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.type = in.readString();
        this.canonicalUrl = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
