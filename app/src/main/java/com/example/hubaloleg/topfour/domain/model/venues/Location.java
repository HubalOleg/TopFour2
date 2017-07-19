package com.example.hubaloleg.topfour.domain.model.venues;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kostya on 18.07.17.
 */

public class Location implements Parcelable {
    private String address;
    private double lat;
    private double lng;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String countryCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeDouble(this.lat);
        dest.writeDouble(this.lng);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeString(this.country);
        dest.writeString(this.postalCode);
        dest.writeString(this.countryCode);
    }

    public Location() {
    }

    protected Location(Parcel in) {
        this.address = in.readString();
        this.lat = in.readDouble();
        this.lng = in.readDouble();
        this.city = in.readString();
        this.state = in.readString();
        this.country = in.readString();
        this.postalCode = in.readString();
        this.countryCode = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
