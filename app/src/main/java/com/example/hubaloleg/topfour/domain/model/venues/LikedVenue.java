package com.example.hubaloleg.topfour.domain.model.venues;

import android.os.Parcel;
import android.os.Parcelable;

public class LikedVenue implements Parcelable {
    private String id;
    private String name;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.location, flags);
    }

    public LikedVenue() {
    }

    protected LikedVenue(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Creator<LikedVenue> CREATOR = new Creator<LikedVenue>() {
        @Override
        public LikedVenue createFromParcel(Parcel source) {
            return new LikedVenue(source);
        }

        @Override
        public LikedVenue[] newArray(int size) {
            return new LikedVenue[size];
        }
    };
}
