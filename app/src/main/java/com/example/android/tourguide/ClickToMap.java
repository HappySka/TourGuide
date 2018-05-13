package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class ClickToMap implements OnItemClickListener {

    private ArrayList<Attraction> attractions;

    private Context mContext;

    public ClickToMap(Context context, ArrayList<Attraction> attractions) {
        this.mContext = context;
        this.attractions = attractions;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Attraction attraction = attractions.get(position);

        //Add ", Aachen" after the street address for the full address for a map application
        String address = attraction.getAddress();
        address += mContext.getResources().getString(R.string.city_name_map_extension);

        //Parse Address into Uri that consists of the address (no coordinates)
        Uri addressUri = Uri.parse(mContext.getString(R.string.uri_geo_code) + Uri.encode(address));

        //Open an app that can show the location on a map if such an app is installed on the device
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(addressUri);
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(intent);
        }
    }
}
