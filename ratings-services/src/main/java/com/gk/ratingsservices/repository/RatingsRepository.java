package com.gk.ratingsservices.repository;

import com.gk.ratingsservices.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings,String> {

    public List<Ratings> findByUserId (String userId);

    List<Ratings> findByHotelId (String hotelId);

}
