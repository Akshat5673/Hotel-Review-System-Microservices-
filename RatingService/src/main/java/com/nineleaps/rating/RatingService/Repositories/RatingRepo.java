package com.nineleaps.rating.RatingService.Repositories;

import com.nineleaps.rating.RatingService.Models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> findAllByUserId(String userId);

    List<Rating> findAllByHotelId(String hotelId);

    Rating findByUserIdAndHotelId(String userId, String hotelId);

}
