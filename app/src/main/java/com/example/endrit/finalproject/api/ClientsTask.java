package com.example.endrit.finalproject.api;

import android.os.AsyncTask;

import java.io.IOException;

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

        Request request = new Request.Builder().url(url).build();
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
    }

    private void onSuccessResponse(String response) {
        //TODO: get the data and put them inside an arraylist
    }
}
