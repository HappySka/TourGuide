package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Activity context, ArrayList<Attraction> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        //Set attraction name
        TextView nameText = listItemView.findViewById(R.id.attraction_name);
        nameText.setText(currentAttraction.getAttractionName());

        //Set additional info
        TextView infoText = listItemView.findViewById(R.id.attraction_info);
        infoText.setText(currentAttraction.getShortInfo());

        //Set address
        TextView addressText = listItemView.findViewById(R.id.attraction_address);
        addressText.setText(currentAttraction.getAddress());

        //Set image if attraction has one
        ImageView image = listItemView.findViewById(R.id.image);
        if (currentAttraction.hasImage()) {
            image.setImageResource(currentAttraction.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
