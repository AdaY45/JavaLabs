package com.plane.pojo.people;

import com.plane.pojo.plane.Navy;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    Navy order;

    public Client(int id, String firstName, String lastName, Navy order) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.order = order;
    }
}
