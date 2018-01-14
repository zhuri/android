package com.example.endrit.finalproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.endrit.finalproject.R;
import com.example.endrit.finalproject.models.Client;

/**
 * Created by endrit on 1/15/2018.
 */

public class SpecificClientActivity extends Activity {
    TextView id, name, status, email, street_addr, credits;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_specific_client);
        loadViews();
        fillViewsWithData();
    }

    private void loadViews() {
        id = findViewById(R.id.clientId);
        name = findViewById(R.id.clientName);
        status = findViewById(R.id.clientStatus);
        email = findViewById(R.id.clientEmail);
        street_addr = findViewById(R.id.clientStreetAddress);
        credits = findViewById(R.id.clientCredits);
    }

    private void fillViewsWithData() {
        Intent i = getIntent();
        Client client = (Client) i.getSerializableExtra("client");

        id.setText(String.valueOf(client.getId()));
        name.setText(client.getName());
        status.setText(String.valueOf(client.getStatus()));
        email.setText(client.getEmail());
        street_addr.setText(client.getStreet_address());
        credits.setText(String.valueOf(client.getCredits()));
    }


}
