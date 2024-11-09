package com.nineleaps.user.UserService.External.Services;


import com.nineleaps.user.UserService.Models.Rating;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


    @GetMapping("/api/v1/ratings/list/user/{userId}")
    public List<Rating> getRatings(@PathVariable String userId);

//    @PostMapping("/api/v1/ratings/create")
//    public Rating createRating(Rating rating);

}
