package com.nineleaps.user.UserService.Services.Impls;

import com.nineleaps.user.UserService.Dtos.UserDto;
import com.nineleaps.user.UserService.Exceptions.ResourceNotFoundException;
import com.nineleaps.user.UserService.External.Services.HotelService;
import com.nineleaps.user.UserService.External.Services.RatingService;
import com.nineleaps.user.UserService.Models.Hotel;
import com.nineleaps.user.UserService.Models.Rating;
import com.nineleaps.user.UserService.Models.User;
import com.nineleaps.user.UserService.Repositories.UserRepo;
import com.nineleaps.user.UserService.Services.UserService;
import com.nineleaps.user.UserService.Utils.GenericEntityDtoAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo repo;

    private final HotelService hotelService;

    private final RatingService ratingService;

    @Autowired
    public UserServiceImpl(UserRepo repo, HotelService hotelService, RatingService ratingService) {
        this.repo = repo;
        this.hotelService = hotelService;
        this.ratingService = ratingService;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = GenericEntityDtoAdapter.toEntityObject(userDto,User.class);
        user.setUserId(UUID.randomUUID().toString());
        User newUser = repo.save(user);
        return GenericEntityDtoAdapter.toDtoObject(newUser, UserDto.class);
    }

    @Override
    public UserDto getUser(String userId) {
        User user = repo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        List<Rating> ratingsByUser = ratingService.getRatings(user.getUserId());

        List<Rating> finalRatingList = ratingsByUser.stream().map( rating -> {
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
            }
            ).toList();

        user.setRatings(finalRatingList);
        return GenericEntityDtoAdapter.toDtoObject(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = repo.findAll();
        return GenericEntityDtoAdapter.toDtoList(userList, UserDto.class);
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        User user= repo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        User updatedUser = repo.save(user);
        return GenericEntityDtoAdapter.toDtoObject(updatedUser,UserDto.class);
    }

    @Override
    public void deleteUser(String userId) {
        User user= repo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
        repo.delete(user);
    }
}
