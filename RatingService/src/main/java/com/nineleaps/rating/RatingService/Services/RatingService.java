package com.nineleaps.rating.RatingService.Services;

import com.nineleaps.rating.RatingService.Dtos.RatingDto;

import java.util.List;

public interface RatingService {

    RatingDto createRating(RatingDto ratingDto);

    List<RatingDto> getAllRatings();

    List<RatingDto> getAllByUser(String userId);

    List<RatingDto> getAllByHotel(String hotelId);

    RatingDto getRating(String userId, String hotelId);

}
