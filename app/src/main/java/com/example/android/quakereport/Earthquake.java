package com.example.android.quakereport;

public class Earthquake {
    private double mMagnitude;

    private String mCityName;

    private long mTimeInMilliseconds;

    private String mUrl;


    public Earthquake(double mMagnitude, String mCityName, long mTimeInMilliseconds, String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mCityName = mCityName;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
        this.mUrl = mUrl;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getCityName() {
        return mCityName;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {
        return mUrl;
    }

}
