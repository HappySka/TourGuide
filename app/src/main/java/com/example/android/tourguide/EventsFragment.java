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
public class EventsFragment extends Fragment {


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        //List of attractions
        ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Award of Charlemagne Prize of Aachen", "10. May", "Markt"));
        attractions.add(new Attraction("CHIO", "13. - 22. July, International Horse Show", "Albert-Servais-Allee 50"));
        attractions.add(new Attraction("Christmas Market", "24. November - 23. December", "Markt"));

        //Create an adapter for the attractions and set it for the list view
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Open a map/navigation app when an item is clicked with the address of the attraction
        listView.setOnItemClickListener(new ClickToMap(getActivity(), attractions));

        return rootView;
    }

}
