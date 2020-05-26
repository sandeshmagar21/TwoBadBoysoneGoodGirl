package com.example.futsalapp;

public class futsallist {
    private  String futsalName;
    private  String futsalLocation;
    private int futsalImageId;

    public futsallist(String futsalName, String futsalLocation, int futsalImageId) {
        this.futsalName = futsalName;
        this.futsalLocation = futsalLocation;
        this.futsalImageId = futsalImageId;
    }

    public String getFutsalName() {
        return futsalName;
    }

    public String getFutsalLocation() {
        return futsalLocation;
    }

    public int getFutsalImageId() {
        return futsalImageId;
    }
}
