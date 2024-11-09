package com.nineleaps.rating.RatingService.Controllers;

import com.nineleaps.rating.RatingService.Dtos.RatingDto;
import com.nineleaps.rating.RatingService.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ratings")
public class RatingController {

    private final RatingService service;

    @Autowired
    public RatingController(RatingService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<RatingDto> create(@RequestBody RatingDto ratingDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(ratingDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<RatingDto>> list(){
        return ResponseEntity.ok(service.getAllRatings());
    }

    @GetMapping("/list/user/{userId}")
    public ResponseEntity<List<RatingDto>> fetchAllByUser(@PathVariable String userId){
        return ResponseEntity.ok(service.getAllByUser(userId));
    }


    @GetMapping("/list/hotel/{hotelId}")
    public ResponseEntity<List<RatingDto>> fetchAllByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(service.getAllByHotel(hotelId));
    }

    @GetMapping("/retrieve/user/{userId}/hotel/{hotelId}")
    public ResponseEntity<RatingDto> retrieve(@PathVariable String userId, @PathVariable String hotelId){
        return ResponseEntity.ok(service.getRating(userId,hotelId));
    }


}
