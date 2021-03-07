package com.plane.pojo.plane;

public class Company {
    String name;
    int trustIndex;

    public Company(String name,int trustIndex) {
        this.name = name;
        this.trustIndex = trustIndex;
    }

    public int getTrustIndex() {
        return trustIndex;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name of company:  " + name;
    }
}
