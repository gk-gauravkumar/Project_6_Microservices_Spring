package com.gk.hotelservices.controller;

import com.gk.hotelservices.entity.Hotel;
import com.gk.hotelservices.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("hotel")
public class HotelController {

    private static Logger log = LoggerFactory.getLogger(HotelController.class);
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel Hotel){
        String hotelId = UUID.randomUUID().toString();
        Hotel.setId(hotelId);
        Hotel Hotel1 = hotelService.create(Hotel);
        log.info("Hotel Details Saved Successfully");
        return ResponseEntity.ok(Hotel1);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels (){
        List<Hotel> allHotelsList = hotelService.getAll();
        log.info("All Hotels Details Fetched Successfully");
        return ResponseEntity.ok(allHotelsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id){
        Hotel Hotel1 = hotelService.get(id);
        log.info("Hotel Details Fetched Successfully");
        return ResponseEntity.ok(Hotel1);
    }
    
}
