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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        //List of attractions
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.leonardo_hotel), getString(R.string.four_stars), getString(R.string.leonardo_hotel_address)));
        attractions.add(new Attraction(getString(R.string.A_and_O), getString(R.string.two_stars), getString(R.string.a_and_o_address)));
        attractions.add(new Attraction(getString(R.string.mercure_hotel), getString(R.string.four_stars), getString(R.string.mercure_hotel_address)));

        //Create an adapter for the attractions and set it for the list view
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Open a map/navigation app when an item is clicked with the address of the attraction
        listView.setOnItemClickListener(new ClickToMap(getActivity(), attractions));

        return rootView;
    }

}
