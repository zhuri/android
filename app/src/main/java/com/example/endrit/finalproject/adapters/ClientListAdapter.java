package com.example.endrit.finalproject.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.endrit.finalproject.R;
import com.example.endrit.finalproject.activities.SpecificClientActivity;
import com.example.endrit.finalproject.models.Client;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by endrit on 1/14/2018.
 */

public class ClientListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Client> clients = new ArrayList<>();

    public ClientListAdapter(Context context, ArrayList<Client> clients) {
        this.context = context;
        this.clients = clients;
        setUpInflater();
    }

    private void setUpInflater() {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return clients.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class Holder {
        TextView client_id, client_name;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
//        System.out.println("here from get view method");
        if(view == null) {
            view = inflater.inflate(R.layout.layout_clients_cell, viewGroup, false);
            holder = new Holder();
            holder.client_id = view.findViewById(R.id.client_id);
            holder.client_name = view.findViewById(R.id.client_name);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        Client client = clients.get(i);

        holder.client_id.setText(String.valueOf(client.getId()));
        holder.client_name.setText(client.getName());

        return view;
    }
}
