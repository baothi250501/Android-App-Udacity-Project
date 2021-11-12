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

        // Create a fake list of earthquakes.
        ArrayList<EarthquakeEvent> earthquakes = QueryUtils.extractEarthquakes();

        //Find a reference to the {@link Listview} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        //Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        //Set the adapter on the {@link ListView} so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}