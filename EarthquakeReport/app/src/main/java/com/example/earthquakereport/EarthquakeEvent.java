package com.example.earthquakereport;

public class EarthquakeEvent {

    private String mMagnitude;
    private String mLocation;
    private String mDate;

    /*
     * Create a new EarthquakeEvent object
     *
     * @param mMagnitude is the magnitude of earthquake event
     * @param mLocation is the location of earthquake event
     * @param mDate is the date of earthquake event
     * */
    public EarthquakeEvent(String magnitude, String location, String date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    /**
     * Get the date of earthquake event
     */
    public String getmDate() {
        return mDate;
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
