package com.github.lelouchhe.fragmentsrecyclerview;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter carAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_list, container, false);

        return this.view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.recyclerView = this.view.findViewById(R.id.list);
        this.recyclerView.setHasFixedSize(true);

        // layout only can't handle reverse-portrait
        int layoutOrientation = this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? LinearLayoutManager.HORIZONTAL : LinearLayoutManager.VERTICAL;

        this.layoutManager = new LinearLayoutManager(this.getActivity(), layoutOrientation, false);
        this.recyclerView.setLayoutManager(this.layoutManager);

        this.carAdapter = new CarAdapter(this.getActivity(), MyApplication.Cars);
        this.recyclerView.setAdapter(this.carAdapter);
    }
}
