package com.gk.hotelservices.service;

import com.gk.hotelservices.entity.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);

}
