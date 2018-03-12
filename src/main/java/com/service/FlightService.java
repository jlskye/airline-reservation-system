package com.service;

import com.bean.Flightbean;

public interface FlightService {
    Flightbean search(String go_city,String arrive_city,String go_date,String plane_name);
}
