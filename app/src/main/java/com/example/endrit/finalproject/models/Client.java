package com.example.endrit.finalproject.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by endrit on 1/8/2018.
 */

public class Client implements Serializable {

    private int id;
    private String name;
    private String street_address;
    private String email;
    private int status;
    private double credits;

    public Client() {
    }

    public Client(JSONObject object) {
        this.id = object.optInt("id", 0);
        this.name = object.optString("name", "");
        this.street_address = object.optString("street_address", "");
        this.email = object.optString("email", "");
        this.status = object.optInt("status", -1);
        this.credits = object.optDouble("credits", -1);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
}
