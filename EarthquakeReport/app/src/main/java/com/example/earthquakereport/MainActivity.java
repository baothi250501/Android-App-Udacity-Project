package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a fake list of earthquake locations.
        ArrayList<EarthquakeEvent> earthquakes = new ArrayList<EarthquakeEvent>();
        earthquakes.add(new EarthquakeEvent("2.0", "San Francisco", "Feb 2, 2016"));
        earthquakes.add(new EarthquakeEvent("5.0", "London", "July 20, 2017"));
        earthquakes.add(new EarthquakeEvent("3.9", "Tokyo", "Nov 1 0, 2015"));
        earthquakes.add(new EarthquakeEvent("4.5", "Mexico City", "June 6, 2012"));
        earthquakes.add(new EarthquakeEvent("5.6","Moscow", "Aug 19, 2015"));
        earthquakes.add(new EarthquakeEvent("1.5", "Rio de Janeiro", "Oct 20, 2012"));
        earthquakes.add(new EarthquakeEvent("7.2", "Paris", "Jan 31, 2018"));

        //Find a reference to the {@link Listview} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        //Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        //Set the adapter on the {@link ListView} so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}