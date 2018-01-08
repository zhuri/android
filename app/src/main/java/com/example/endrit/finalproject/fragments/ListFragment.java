package com.example.endrit.finalproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.endrit.finalproject.R;

/**
 * Created by endrit on 1/8/2018.
 */

public class ListFragment extends android.app.ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.layout_fragment, container, false);
        String[] data = {"English", "French", "Japanese", "Chinese", "Albanin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_fragment_cell, R.id.fragment_text, data);
        setListAdapter(adapter);

        setRetainInstance(true);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ViewGroup viewGroup = (ViewGroup) v;
        TextView textView = viewGroup.findViewById(R.id.fragment_text);
        Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_LONG).show();
    }
}
