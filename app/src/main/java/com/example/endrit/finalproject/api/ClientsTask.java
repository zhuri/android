package com.example.endrit.finalproject.api;

import android.os.AsyncTask;

import com.example.endrit.finalproject.models.Client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by endrit on 1/8/2018.
 */

public class ClientsTask extends AsyncTask<String, Integer, String>{

    ClientsCallback clientsCallback;
    public ClientsTask(ClientsCallback clientsCallback) {
        this.clientsCallback = clientsCallback;
    }

    @Override
    protected String doInBackground(String... strings) {
        final String url = Endpoint.endpoint;
        final OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .build();
        Response response;

        try {
            response = client.newCall(request).execute();
            final String stringResponse;
            stringResponse = response.body().string();
            return stringResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //TODO: call onSuccessResponse
        if (s != null) {
            onSuccessResponse(s);
        } else {
            clientsCallback.onClientsResponse(null, false);
            System.out.println("something did go wrong");
        }
    }

    private void onSuccessResponse(String response) {
        //TODO: get the data and put them inside an arraylist
        ArrayList<Client> arrayList = new ArrayList<>();
        try {
            final JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {

                final JSONObject jsonObject = jsonArray.optJSONObject(i);
                final Client client = new Client(jsonObject);
                arrayList.add(client);
                System.out.println("Name: " + client.getName());
            }
            clientsCallback.onClientsResponse(arrayList, true);
        } catch (JSONException e) {
            e.printStackTrace();
            clientsCallback.onClientsResponse(null, false);
        }
    }
}
