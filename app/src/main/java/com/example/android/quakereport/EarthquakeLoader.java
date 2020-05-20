package com.example.android.quakereport;

import android.content.Context;

import android.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    /** Query URL */
    private String mUrl;


    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }



    @Override
    protected void onStartLoading() {
        forceLoad();
    }



    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
