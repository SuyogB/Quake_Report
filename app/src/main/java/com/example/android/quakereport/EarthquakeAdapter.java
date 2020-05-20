package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    String offsetLocation,primaryLocation;
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0,earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);




        TextView magnitudeTextView =  listItemView.findViewById(R.id.magnitude_text_view);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);



        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        magnitudeTextView.setText(formattedMagnitude);

        String originalLocation = currentEarthquake.getCityName();


        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts  =originalLocation.split(LOCATION_SEPARATOR);
            offsetLocation = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }else {
            offsetLocation = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }


        TextView offsetTextView =  listItemView.findViewById(R.id.offsetLocation_text_view);
        TextView primaryTextView =  listItemView.findViewById(R.id.primaryLocation_text_view);


        offsetTextView.setText(offsetLocation);
        primaryTextView.setText(primaryLocation);



        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        TextView dateTextView =  listItemView.findViewById(R.id.date_text_view);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeTextView =  listItemView.findViewById(R.id.time_text_view);
        String formattedTime = formatTime(dateObject);
        timeTextView.setText(formattedTime);



        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int color = 0;
        switch((int) magnitude){
            case (0):
            case (1):
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case (2):
                color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case (3):
                color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case (4):
                color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case (5):
                color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case (6):
                color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case (7):
                color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case (8):
                color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case (9):
                color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            case (10):
                color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        }
        return color;
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormatter.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
