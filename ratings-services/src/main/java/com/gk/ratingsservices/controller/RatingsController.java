package com.gk.ratingsservices.controller;

import com.gk.ratingsservices.entity.Ratings;
import com.gk.ratingsservices.services.RatingsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    private static Logger log = LoggerFactory.getLogger(RatingsController.class);
    @Autowired
    private RatingsServices RatingsServices;

    @PostMapping
    public ResponseEntity<Ratings> saveRatings(@RequestBody Ratings Ratings){
        Ratings Ratings1 = RatingsServices.saveRating(Ratings);
        log.info("Ratings Details Saved Successfully");
        return ResponseEntity.ok(Ratings1);
    }

    @GetMapping
    public ResponseEntity<List<Ratings>> getAllRatingss (){
        List<Ratings> allRatingssList = RatingsServices.getAllRatings();
        log.info("All Ratingss Details Fetched Successfully");
        return ResponseEntity.ok(allRatingssList);
    }

    @GetMapping("getbyuserid/{userId}")
    public ResponseEntity<List<Ratings>> getRatingByUserId(@PathVariable String userId){
        List<Ratings> Ratings1 = RatingsServices.getByUserId(userId);
        log.info("Ratings Details Fetched Successfully");
        return ResponseEntity.ok(Ratings1);
    }
    @GetMapping("getbyhotelid/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingByHotelId(@PathVariable String hotelId){
        List<Ratings> Ratings1 = RatingsServices.getByHotelId(hotelId);
        log.info("Ratings Details Fetched Successfully");
        return ResponseEntity.ok(Ratings1);
    }

}
