package com.gk.userservices.services;

import com.gk.userservices.entity.Rating;
import com.gk.userservices.entity.User;
import com.gk.userservices.entity.Hotel;
import com.gk.userservices.repository.UserRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserid(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers()  {

        List<User> users = userRepository.findAll();
        List<User> userListWithRatingAndHotel = users.stream().map(user -> {
            Rating[] list = restTemplate.getForObject("http://RATING-SERVICE/ratings/getbyuserid/"+user.getUserid(), Rating[].class);
            List<Rating> newList = Arrays.stream(list).toList();
            List<Rating> ratingList = newList.stream().map(rating -> {
                Hotel hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(),Hotel.class).getBody();
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());
            user.setRatings(ratingList);
            return user;
        }).collect(Collectors.toList());
        return userListWithRatingAndHotel;

    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not found with the given id : "+userId));
        //REST API CALL rating get method
        Rating[] list = restTemplate.getForObject("http://RATING-SERVICE/ratings/getbyuserid/"+user.getUserid(), Rating[].class);
        List<Rating> newList = Arrays.stream(list).toList();
        List<Rating> ratingList = newList.stream().map(rating -> {
           Hotel hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(),Hotel.class).getBody();
           rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());user.setRatings(ratingList);
        return user;
    }

    @Override
    public void delete(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not found with the given id : "+userId));
        userRepository.delete(user);
    }


}
