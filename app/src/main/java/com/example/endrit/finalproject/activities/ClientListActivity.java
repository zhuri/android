package com.example.endrit.finalproject.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.endrit.finalproject.R;
import com.example.endrit.finalproject.adapters.ClientListAdapter;
import com.example.endrit.finalproject.api.ClientsCallback;
import com.example.endrit.finalproject.api.ClientsTask;
import com.example.endrit.finalproject.fragments.ClientListFragment;
import com.example.endrit.finalproject.models.Client;

import java.util.ArrayList;

/**
 * Created by endrit on 1/14/2018.
 */

public class ClientListActivity extends Activity {

    ListView listView;
    ArrayList<Client> clientsList = new ArrayList<>();
    ClientsTask clientsTask;
    ClientsCallback clientsCallback;
    ClientListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_clients);
        listView = findViewById(R.id.client_list);
        adapter = new ClientListAdapter(getApplicationContext(), clientsList);
        listView.setAdapter(adapter);
        initService();
        requestClients();
        seeSpecificClient();
    }

    private void initService() {
        System.out.println("here from init the service");
        clientsCallback = new ClientsCallback() {
            @Override
            public void onClientsResponse(ArrayList<Client> clients, boolean success) {
                if (success) {
                    clientsList.addAll(clients);
                    adapter.notifyDataSetChanged();
//                    System.out.println("inside the response: " + clientsList);
                } else {
                    Toast.makeText(getApplicationContext(), "could not load clients", Toast.LENGTH_LONG).show();
                }
            }
        };
        clientsTask = new ClientsTask(clientsCallback);
    }

    private void requestClients() {
        clientsTask.execute();
    }

    private void seeSpecificClient() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SpecificClientActivity.class);
                intent.putExtra("client", clientsList.get(i));
                startActivity(intent);
            }
        });
    }
}
