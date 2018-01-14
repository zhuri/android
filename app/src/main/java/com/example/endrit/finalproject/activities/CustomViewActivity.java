package com.example.endrit.finalproject.activities;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.endrit.finalproject.R;
import com.example.endrit.finalproject.fragments.ClientListFragment;

/**
 * Created by endrit on 1/7/2018.
 */

public class CustomViewActivity extends Activity {

    Button clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        loadViews();
        loadListFragment();
    }

    private void loadListFragment() {
        clients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClientListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadViews() {
        clients = findViewById(R.id.clients_list);
    }


}
