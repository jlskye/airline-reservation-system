package com.bean;

import java.io.Serializable;

//flight_number作为主键，用来查找结果
public class Planebean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int flight_number;//航班编号
    private String plane_name;
    private String plane_number;
    private String plane_type;//飞机型号
    private String seat_type;
    private int seat_number;
    private int seat_price;

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getPlane_name() {
        return plane_name;
    }

    public void setPlane_name(String plane_name) {
        this.plane_name = plane_name;
    }

    public String getPlane_number() {
        return plane_number;
    }

    public void setPlane_number(String plane_number) {
        this.plane_number = plane_number;
    }

    public String getPlane_type() {
        return plane_type;
    }

    public void setPlane_type(String plane_type) {
        this.plane_type = plane_type;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getSeat_price() {
        return seat_price;
    }

    public void setSeat_price(int seat_price) {
        this.seat_price = seat_price;
    }
}

