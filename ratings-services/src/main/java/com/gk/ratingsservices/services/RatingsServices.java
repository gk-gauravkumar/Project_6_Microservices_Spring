package com.gk.ratingsservices.services;

import com.gk.ratingsservices.entity.Ratings;

import java.util.List;

public interface RatingsServices {

    Ratings saveRating(Ratings ratings);

    List<Ratings> getAllRatings ();

    List<Ratings> getByUserId(String userId);

    List<Ratings> getByHotelId(String hotelId);



}
