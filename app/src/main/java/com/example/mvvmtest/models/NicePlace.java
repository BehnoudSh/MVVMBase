package com.example.mvvmtest.models;

public class NicePlace {
    String nicePlaceName;
    int nicePlaceImg;

    public NicePlace(String nicePlaceName, int nicePlaceImg) {
        this.nicePlaceName = nicePlaceName;
        this.nicePlaceImg = nicePlaceImg;
    }

    public String getNicePlaceName() {
        return nicePlaceName;
    }

    public void setNicePlaceName(String nicePlaceName) {
        this.nicePlaceName = nicePlaceName;
    }

    public int getNicePlaceImg() {
        return nicePlaceImg;
    }

    public void setNicePlaceImg(int nicePlaceImg) {
        this.nicePlaceImg = nicePlaceImg;
    }
}
