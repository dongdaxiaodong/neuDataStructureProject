package com.bladejava.service.projectDataStructure;

/**
* 停车场类
* */
import com.bladejava.service.definedDataStructure.myQueue;

public class parkinglot {
    private myQueue parking;
    private int size;

    public parkinglot(myQueue parking,int size){
        this.parking=parking;
        this.size=size;
    }

    public myQueue getParking() {
        return parking;
    }

    public void setParking(myQueue parking) {
        this.parking = parking;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
