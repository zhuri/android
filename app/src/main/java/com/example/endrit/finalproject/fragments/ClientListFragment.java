package com.example.endrit.finalproject.fragments;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.endrit.finalproject.R;

public class ClientListFragment extends ListFragment {

    String[] countries = {"Kosova", "Albania", "Usa"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("inside fragment on create view");
        View view = inflater.inflate(R.layout.layout_clients, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("inside adapter on create activity");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, countries);
        setListAdapter(adapter);
    }
}
