package com.example.android.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {


    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        //List of attractions
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.aachen_cathedral), getString(R.string.world_heritage), getString(R.string.cathedral_address), R.drawable.aachen_cathedral));
        attractions.add(new Attraction(getString(R.string.town_hall), getString(R.string.town_hall_description), getString(R.string.town_hall_address), R.drawable.aachen_cityhall));
        attractions.add(new Attraction(getString(R.string.ponttor), getString(R.string.ponttor_description), getString(R.string.ponttor_address), R.drawable.aachen_ponttor));

        //Create an adapter for the attractions and set it for the list view
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Open a map/navigation app when an item is clicked with the address of the attraction
        listView.setOnItemClickListener(new ClickToMap(getActivity(), attractions));

        return rootView;
    }

}
