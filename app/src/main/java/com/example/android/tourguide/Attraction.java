package com.example.android.tourguide;


public class Attraction {

    private String mName;

    private String mAddress;

    private String mShortInfo;

    private final int HAS_NO_IMAGE = -1;

    private int mImageResourceId = HAS_NO_IMAGE;


    public Attraction(String mName, String mShortInfo, String mAddress) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mShortInfo = mShortInfo;
    }

    public Attraction(String mName, String mShortInfo, String mAddress, int mImageResourceId) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mShortInfo = mShortInfo;
        this.mImageResourceId = mImageResourceId;
    }

    public String getAttractionName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getShortInfo() {
        return mShortInfo;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != HAS_NO_IMAGE;
    }


}
