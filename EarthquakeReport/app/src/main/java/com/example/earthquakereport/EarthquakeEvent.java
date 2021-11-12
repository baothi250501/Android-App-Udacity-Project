package com.example.earthquakereport;

public class EarthquakeEvent {

    private String mMagnitude;
    private String mLocation;
    private long mTimeMilliseconds;

    /*
     * Create a new EarthquakeEvent object
     *
     * @param mMagnitude is the magnitude of earthquake event
     * @param mLocation is the location of earthquake event
     * @param mDate is the date of earthquake event
     * */
    public EarthquakeEvent(String magnitude, String location, long timeMilliseconds){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeMilliseconds = timeMilliseconds;
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
    public String getmMagnitude() {
        return mMagnitude;
    }
}
