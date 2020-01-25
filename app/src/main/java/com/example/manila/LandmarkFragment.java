package com.example.manila;


import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class LandmarkFragment extends Fragment {
    private DatabaseHelperForUsers mydb;
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Landmarks> landmarks;
    private int userID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_landmark, container, false);
        mydb = new DatabaseHelperForUsers(view.getContext());
         userID = getArguments().getInt("User");
        Cursor res = mydb.getAllDataForLandmarks();
        if (res.getCount() == 0) {
            Toast.makeText(getActivity(), "Empty", Toast.LENGTH_SHORT).show();
            return view;
        } else {
            view = loadDatabase(view);
        }
        return view;

    }

    public View loadDatabase(View view) {
        recyclerView = view.findViewById(R.id.ListmeDisplayOnly);
        mydb = new DatabaseHelperForUsers(getActivity());
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        landmarks = new ArrayList<Landmarks>();
        Cursor res = mydb.getAllDataForLandmarks();
        if (res.getCount() == 0) {
            landmarks.clear();
        } else {
            while (res.moveToNext()) {
                landmarks.add(new Landmarks(res.getString(1), res.getString(5), res.getString(1)));
            }
        }

        myAdapter = new LandmarksAdapterDisplayOnly(getActivity(), landmarks,userID);
        recyclerView.setAdapter(myAdapter);
        return view;
    }

}





