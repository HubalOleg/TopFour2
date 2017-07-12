package com.example.hubaloleg.topfour.domain.model;

/**
 * Created by hubaloleg on 12.07.17.
 */

public class Icon {

    private String mPrefix;
    private String mSuffix;

    public Icon() {

    }

    public Icon(String prefix, String suffix) {
        mPrefix = prefix;
        mSuffix = suffix;
    }

    public String getPrefix() {
        return mPrefix;
    }

    public String getSuffix() {
        return mSuffix;
    }
}
