package com.example.endrit.finalproject.api;

import com.example.endrit.finalproject.models.Client;

import java.util.ArrayList;

/**
 * Created by endrit on 1/8/2018.
 */

public interface ClientsCallback {

    void onClientsResponse(final ArrayList<Client> clients, boolean success);
}
