package com.bladejava.service.projectDataStructure;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name="parking")
public class car extends Model {

    @Column(name="id")
    private int id;
    @Column(name = "carid")
    private String carNumber;
    @Column(name="status")
    private String status;
    @Column(name="start")
    private String startTime;
    @Column(name="end")
    private String endTime;

    public car(String carNumber,String status){
        this.carNumber=carNumber;
        this.status=status;
    }
    public car(int id,String carNumber,String status,String startTime,String endTime){
        this.id=id;
        this.carNumber=carNumber;
        this.status=status;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

