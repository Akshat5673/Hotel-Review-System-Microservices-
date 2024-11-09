package com.nineleaps.user.UserService.External.Services;

import com.nineleaps.user.UserService.Models.Hotel;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {


    @GetMapping("/api/v1/hotels/retrieve/{hotelId}")
    public Hotel getHotel(@PathVariable String hotelId);

}
