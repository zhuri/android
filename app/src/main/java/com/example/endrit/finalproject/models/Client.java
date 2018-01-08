package com.example.endrit.finalproject.models;

/**
 * Created by endrit on 1/8/2018.
 */

public class Client {
    private int id;
    private String name;
    private String street_address;

    public Client() {
    }

    public Client(int id, String name, String street_address) {
        this.id = id;
        this.name = name;
        this.street_address = street_address;
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
}
