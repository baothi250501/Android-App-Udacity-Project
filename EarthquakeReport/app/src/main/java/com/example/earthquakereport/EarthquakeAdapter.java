package com.example.earthquakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/*
 * {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link AndroidFlavor} objects.
 * */
public class EarthquakeAdapter extends ArrayAdapter<EarthquakeEvent> {

    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param earthquakes A List of EarthquakeEvent objects to display in a list
     */
    public EarthquakeAdapter(Context context, List<EarthquakeEvent> earthquakes){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);

        // Get the {@link EarthquakeEvent} object located at this position in the list
        EarthquakeEvent currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        //Formatted Magnitude to "0.0"
        String formattedMagnitude = formatMagnitude(currentEarthquake.getmMagnitude());
        // Set this formatted text on the magnitude TextView
        magnitudeView.setText(formattedMagnitude);
        
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        // Set the color on the magnitude circle
        Log.i("MyColor", Integer.toString(magnitudeColor));
        magnitudeCircle.setColor(magnitudeColor);


        // Spit originalLocation to offsetLocation and primaryLocation
        String originalLocation = currentEarthquake.getmLocation();
        String offsetLocation;
        String primaryLocation;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            offsetLocation = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            offsetLocation = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        // Find the TextView in the list_item.xml layout with the ID location
        TextView offsetLocationView = (TextView) listItemView.findViewById(R.id.offset_location);
        // Set this text on the offset location TextView
        offsetLocationView.setText(offsetLocation);

        // Find the TextView in the list_item.xml layout with the ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Set this text on the primary location TextView
        primaryLocationView.setText(primaryLocation);

        //Create a new Date object from time in milliseconds of the earthquake
        Date dateObject = new Date (currentEarthquake.getmTimeMilliseconds());
        // Find the TextView in the list_item.xml layout with the ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceID;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceID = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceID = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceID = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceID = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceID = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceID = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceID = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceID = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceID = R.color.magnitude9;
                break;
            default:magnitudeColorResourceID = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceID);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat formatMagnitude = new DecimalFormat("0.0");
        return formatMagnitude.format(magnitude);
    }

    private String formatTime(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
