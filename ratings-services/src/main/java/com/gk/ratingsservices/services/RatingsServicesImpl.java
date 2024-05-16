package com.gk.ratingsservices.services;

import com.gk.ratingsservices.entity.Ratings;
import com.gk.ratingsservices.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RatingsServicesImpl implements RatingsServices {

    @Autowired
    private RatingsRepository ratingsRepository;
    @Override
    public Ratings saveRating(Ratings ratings) {
        String randomRatingId = UUID.randomUUID().toString();
        ratings.setRatingId(randomRatingId);
        return ratingsRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingsRepository.findAll();
    }

        @Override
    public List<Ratings> getByUserId(String userId) {
        return ratingsRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getByHotelId(String hotelId) {
        return ratingsRepository.findByHotelId(hotelId);
    }
}
