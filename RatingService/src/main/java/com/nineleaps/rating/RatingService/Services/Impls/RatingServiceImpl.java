package com.nineleaps.rating.RatingService.Services.Impls;

import com.nineleaps.rating.RatingService.Dtos.RatingDto;
import com.nineleaps.rating.RatingService.Models.Rating;
import com.nineleaps.rating.RatingService.Repositories.RatingRepo;
import com.nineleaps.rating.RatingService.Services.RatingService;
import com.nineleaps.rating.RatingService.Utils.GenericEntityDtoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepo repo;


    @Autowired
    public RatingServiceImpl(RatingRepo repo) {
        this.repo = repo;
    }

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating= GenericEntityDtoAdapter.toEntityObject(ratingDto, Rating.class);
        Rating createdRating = repo.save(rating);
        return GenericEntityDtoAdapter.toDtoObject(createdRating, RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllRatings() {
        List<Rating> allRatings = repo.findAll();
        return GenericEntityDtoAdapter.toDtoList(allRatings, RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllByUser(String userId) {
        List<Rating> userRatings = repo.findAllByUserId(userId);
        return GenericEntityDtoAdapter.toDtoList(userRatings, RatingDto.class);
    }

    @Override
    public List<RatingDto> getAllByHotel(String hotelId) {
        List<Rating> hotelRatings = repo.findAllByHotelId(hotelId);
        return GenericEntityDtoAdapter.toDtoList(hotelRatings, RatingDto.class);
    }

    @Override
    public RatingDto getRating(String userId, String hotelId) {
        Rating rating = repo.findByUserIdAndHotelId(userId,hotelId);
        return GenericEntityDtoAdapter.toDtoObject(rating, RatingDto.class);
    }
}
