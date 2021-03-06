package com.example.earthquakereport;

public class EarthquakeEvent {

    private double mMagnitude;
    private String mLocation;
    private long mTimeMilliseconds;
    private String mUrl;

    /*
     * Create a new EarthquakeEvent object
     *
     * @param mMagnitude is the magnitude of earthquake event
     * @param mLocation is the location of earthquake event
     * @param mDate is the date of earthquake event
     * */
    public EarthquakeEvent(double magnitude, String location, long timeMilliseconds, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeMilliseconds = timeMilliseconds;
        mUrl = url;
    }

    /**
     * Get the time of earthquake event
     */
    public long getmTimeMilliseconds() {
        return mTimeMilliseconds;
    }

    /**
     * Get the location of earthquake event
     */
    public String getmLocation() {
        return mLocation;
    }

    /**
     * Get the magnitude of earthquake event
     */
    public double getmMagnitude() {
        return mMagnitude;
    }

    /**
     * Get the url of earthquake event
     */
    public String getmUrl() {
        return mUrl;
    }
}
