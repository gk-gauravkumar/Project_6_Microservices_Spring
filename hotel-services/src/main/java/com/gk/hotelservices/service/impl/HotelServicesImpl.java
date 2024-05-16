package com.gk.hotelservices.service.impl;

import com.gk.hotelservices.entity.Hotel;
import com.gk.hotelservices.exception.ResourceNotFound;
import com.gk.hotelservices.repository.HotelRepository;
import com.gk.hotelservices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServicesImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Resource not found with the given Hotel Id : "+ id));
    }
}
