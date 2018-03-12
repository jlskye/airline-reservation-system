package com.bean;

import java.io.Serializable;

public class Flightbean implements Serializable{
    private static final long serialVersionUID = 1L;

    private String flight_number;
    private String go_date;
    private String go_week;
    private String go_time;
    private String go_airport;
    private String go_city;
    private String arrive_time;
    private String arrive_city;
    private String arrive_airport;

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getGo_date() {
        return go_date;
    }

    public void setGo_date(String go_date) {
        this.go_date = go_date;
    }

    public String getGo_week() {
        return go_week;
    }

    public void setGo_week(String go_week) {
        this.go_week = go_week;
    }

    public String getGo_time() {
        return go_time;
    }

    public void setGo_time(String go_time) {
        this.go_time = go_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getArrive_airport() {
        return arrive_airport;
    }

    public void setArrive_airport(String arrive_airport) {
        this.arrive_airport = arrive_airport;
    }

    public String getGo_airport() {
        return go_airport;
    }

    public void setGo_airport(String go_airport) {
        this.go_airport = go_airport;
    }

    public String getGo_city() {
        return go_city;
    }

    public void setGo_city(String go_city) {
        this.go_city = go_city;
    }

    public String getArrive_city() {
        return arrive_city;
    }

    public void setArrive_city(String arrive_city) {
        this.arrive_city = arrive_city;
    }
}
